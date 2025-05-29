import java.util.*;

class Solution {

    static class State {
        int x, y, dir, time;
        State(int x, int y, int dir, int time) {
            this.x = x;
            this.y = y;
            this.dir = dir;  
            this.time = time;
        }
    }

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public int solution(int[][] board) {
        int n = board.length;
        boolean[][][] visited = new boolean[n][n][2];
        Queue<State> queue = new LinkedList<>();

        queue.offer(new State(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();
            int x = cur.x, y = cur.y, dir = cur.dir, t = cur.time;

            int x2 = x + (dir == 0 ? 0 : 1);
            int y2 = y + (dir == 0 ? 1 : 0);

            if ((x == n - 1 && y == n - 1) || (x2 == n - 1 && y2 == n - 1)) {
                return t;
            }

            for (int i = 0; i < 4; i++) {
                int nx1 = x + dx[i];
                int ny1 = y + dy[i];
                int nx2 = x2 + dx[i];
                int ny2 = y2 + dy[i];
                
                if (isIn(nx1, ny1, n) && isIn(nx2, ny2, n)
                 && board[nx1][ny1] == 0 && board[nx2][ny2] == 0
                 && !visited[nx1][ny1][dir]) {

                    visited[nx1][ny1][dir] = true;
                    queue.offer(new State(nx1, ny1, dir, t + 1));
                }
            }

    
            if (dir == 0) {  
                for (int d : new int[]{-1, 1}) {
                    int nx = x + d;
                    
                    if (!isIn(nx, y, n) || !isIn(nx, y + 1, n)
                     || board[nx][y] != 0 || board[nx][y + 1] != 0) continue;

                    int baseX = Math.min(x, nx);
                    
                    if (!visited[baseX][y][1]) {
                        visited[baseX][y][1] = true;
                        queue.offer(new State(baseX, y, 1, t + 1));
                    }
                    
                    if (!visited[baseX][y + 1][1]) {
                        visited[baseX][y + 1][1] = true;
                        queue.offer(new State(baseX, y + 1, 1, t + 1));
                    }
                }
            } else {        
                for (int d : new int[]{-1, 1}) {
                    int ny = y + d;
                    
                    if (!isIn(x, ny, n) || !isIn(x + 1, ny, n)
                     || board[x][ny] != 0 || board[x + 1][ny] != 0) continue;

                    int baseY = Math.min(y, ny);
                    
                    if (!visited[x][baseY][0]) {
                        visited[x][baseY][0] = true;
                        queue.offer(new State(x, baseY, 0, t + 1));
                    }
                    
                    if (!visited[x + 1][baseY][0]) {
                        visited[x + 1][baseY][0] = true;
                        queue.offer(new State(x + 1, baseY, 0, t + 1));
                    }
                }
            }
        }

        return -1;
    }

    private boolean isIn(int x, int y, int n) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}
