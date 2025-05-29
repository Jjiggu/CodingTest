class Solution {
    
    static int N;
    static int[][][] map;

    
    class Build {
        int x, y, a, b;
        public Build(int x, int y, int a, int b) {
            this.x = x;
            this.y = y;
            this.a = a;
            this.b = b;
        }
    }

    
    public int[][] solution(int n, int[][] build_frame) {
        N = n;
        map = new int[n + 1][n + 1][2];
        int resultCnt = 0;

        for (int[] build : build_frame) {
            int x = build[0];
            int y = build[1];
            int a = build[2];
            int b = build[3];

            if (b == 1) { // 설치
                if (canPlaceBeam(x, y, a)) {
                    map[x][y][a] = 1;
                    resultCnt++;
                }
            } else { // 삭제
                if (canRemoveBeam(x, y, a)) {
                    map[x][y][a] = 0;
                    resultCnt--;
                }
            }
        }

        int[][] result = new int[resultCnt][3];
        int ind = 0;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                for (int a = 0; a <= 1; a++) {
                    if (map[i][j][a] == 1) {
                        result[ind][0] = i;
                        result[ind][1] = j;
                        result[ind++][2] = a;
                    }
                }
            }
        }

        return result;
    }

    
    public boolean canPlaceBeam(int x, int y, int a) {
        if (a == 0) { 
            return y == 0 ||
                   (y > 0 && map[x][y - 1][0] == 1) ||
                   (x > 0 && map[x - 1][y][1] == 1) ||
                   (map[x][y][1] == 1);
        } else { 
            return (y > 0 && map[x][y - 1][0] == 1) ||
                   (y > 0 && x + 1 <= N && map[x + 1][y - 1][0] == 1) ||
                   (x > 0 && x + 1 <= N && map[x - 1][y][1] == 1 && map[x + 1][y][1] == 1);
        }
    }

    
    public boolean canRemoveBeam(int x, int y, int a) {
    
        map[x][y][a] = 0;

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                for (int type = 0; type <= 1; type++) {
                    if (map[i][j][type] == 1 && !canPlaceBeam(i, j, type)) {
                        map[x][y][a] = 1; 
                        
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
