import java.util.Arrays;

public class MinimumCostPath {

    // 최소 비용 경로를 계산하는 메서드
    public static int minCost(int[][] cost) {
        int m = cost.length;        // 행 개수
        int n = cost[0].length;     // 열 개수

        int[][] dp = new int[m][n]; // 동적 프로그래밍 테이블 생성

        // 시작점 비용 초기화
        dp[0][0] = cost[0][0];

        // 첫 번째 행 초기화
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + cost[0][i];
        }

        // 첫 번째 열 초기화
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + cost[i][0];
        }

        // 나머지 셀에 대해 최소 비용 계산
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = cost[i][j] + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
            }
        }

        // 최종 최소 비용 반환
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] cost = {
            {1, 2, 3},
            {4, 8, 2},
            {1, 5, 3}
        };

        int minCost = minCost(cost);
        System.out.println("최소 비용 경로: " + minCost);
    }
}
