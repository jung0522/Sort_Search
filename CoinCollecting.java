public class CoinCollecting {

    public static int maxCoins(int[][] grid) {
        int m = grid.length;      // 행의 개수
        int n = grid[0].length;   // 열의 개수

        // DP 테이블 생성
        int[][] dp = new int[m][n];

        // 기저 조건: 시작점
        dp[0][0] = grid[0][0];

        // 첫 번째 행 초기화
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // 첫 번째 열 초기화
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // DP 테이블 채우기
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // 최종 결과 반환
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        // 예제 입력
        int[][] grid = {
            {0, 3, 1, 1},
            {2, 0, 0, 4},
            {1, 5, 3, 1}
        };

        // 결과 출력
        System.out.println("최대 동전 수: " + maxCoins(grid));  // 출력: 12
    }
}
