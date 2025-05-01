class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        
        int M = key.length;
        int N = lock.length;
        
        int size = N + 2 * (M - 1);
        int[][] map = new int[size][size];
        
        for (int i = 0 ; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i + M - 1][j + M - 1] = lock[i][j];
            }
        }
        
        
        for (int r = 0; r < 4; r++) {
            key = rotate(key);
            
            for (int x = 0; x <= size - M; x++) {
                for (int y = 0; y <= size - M; y++) {
                    int[][] tmp = deepCopy(map);
                    
                    for (int i = 0; i < M; i++) {
                        for (int j = 0; j < M; j++) {
                            tmp[x + i][y + j] += key[i][j];
                        }
                    }
                    
                    if (checkLock(tmp, M - 1, N)) return true;
                }
            }
        }
        
        return false;
        
    }
    
    
    private int[][] rotate(int[][] key) {
        int n = key.length;
        int[][] rotated = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[i][j] = key[n - 1 - j][i];
            }
        }
        return rotated;
    }
    
    
    private boolean checkLock(int[][] map, int offset, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++){
                if (map[offset + i][offset + j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
    
    
    private int[][] deepCopy(int[][] arr) {
        int[][] copy = new int[arr.length][arr[0].length];
        
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i].clone();
        }
        
        return copy;
    }
}