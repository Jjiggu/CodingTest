class Solution {

    static int[] dx = {1, 0, 0, -1};             // d, l, r, u
    static int[] dy = {0, -1, 1, 0};
    static String[] direction = {"d", "l", "r", "u"};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {

        int dist = Math.abs(x - r) + Math.abs(y - c);
        if (dist > k || (k - dist) % 2 != 0) return "impossible";

        StringBuilder path = new StringBuilder();

        for (int step = 0; step < k; step++) {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || ny < 1 || nx > n || ny > m) continue;

                int restDist = Math.abs(nx - r) + Math.abs(ny - c);
                int restStep = k - step - 1;

                if (restDist <= restStep && (restStep - restDist) % 2 == 0) {
                    path.append(direction[i]);
                    x = nx;
                    y = ny;
                    break;  // 방향 하나 결정되면 다음 step
                }
            }
        }

        return path.toString();
    }
}
