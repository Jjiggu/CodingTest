import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0}; // 하, 상, 좌, 우
    static int[] dy = {0, 0, -1, 1};

    /**
     * Computes the minimum cost to construct a racetrack from the top-left to the bottom-right corner of the board.
     *
     * <p>The board is represented as a 2D array where 0 indicates a free cell and 1 indicates an obstacle.
     * The method employs a breadth-first search (BFS) to explore all possible paths, calculating the cost of
     * each move as either 100 for continuing in the same direction or 600 when making a turn. A 3D cost array
     * tracks the minimum cost to reach each cell in each of the four possible directions. The search starts
     * by considering only rightward and downward moves from the starting position, ensuring a valid initial path.
     *
     * @param board a 2D grid where 0 denotes a valid path and 1 denotes an obstacle
     * @return the minimum cost required to construct the racetrack to the bottom-right corner of the board
     */
    public int solution(int[][] board) {
        int N = board.length;
        int[][][] cost = new int[N][N][4]; // 방향별 최소 비용

        for (int[][] layer : cost) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }

        Queue<Node> queue = new LinkedList<>();

        // 시작 위치에서 바로 아래 or 오른쪽만 가능 (코너 X)
        if (board[0][1] == 0) {
            queue.add(new Node(0, 1, 100, 3));
            cost[0][1][3] = 100;
        }
        if (board[1][0] == 0) {
            queue.add(new Node(1, 0, 100, 0));
            cost[1][0][0] = 100;
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == 1) continue;

                int newCost = (cur.dir == i) ? cur.cost + 100 : cur.cost + 600;

                if (cost[nx][ny][i] > newCost) {
                    cost[nx][ny][i] = newCost;
                    queue.add(new Node(nx, ny, newCost, i));
                }
            }
        }

        // 도착 지점까지의 최소 비용 (모든 방향 중 가장 작은 값)
        return Arrays.stream(cost[N - 1][N - 1]).min().getAsInt();
    }

    class Node {
        int x, y, cost, dir;
        /**
         * Constructs a new Node instance with the specified board position, accumulated cost, and movement direction.
         *
         * @param x the x-coordinate of the node
         * @param y the y-coordinate of the node
         * @param cost the cumulative cost incurred to reach this node
         * @param dir the direction from which the node was reached, used to determine turning costs
         */
        Node(int x, int y, int cost, int dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }
}
