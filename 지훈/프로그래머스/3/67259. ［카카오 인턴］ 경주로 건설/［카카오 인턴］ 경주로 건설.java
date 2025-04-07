import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0}; // 하, 상, 좌, 우
    static int[] dy = {0, 0, -1, 1};

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
        Node(int x, int y, int cost, int dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }
}
