public class LCS {

    // LCS 길이를 계산하는 함수
    public static int[][] computeLCSLength(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];

        // DP 테이블 채우기
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp;
    }

    // LCS 문자열 복원 함수
    public static String reconstructLCS(String X, String Y, int[][] dp) {
        int i = X.length();
        int j = Y.length();
        StringBuilder lcs = new StringBuilder();

        // 역추적하여 LCS 문자열 복원
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs.append(X.charAt(i - 1)); // 공통 문자 추가
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--; // 위쪽으로 이동
            } else {
                j--; // 왼쪽으로 이동
            }
        }
        return lcs.reverse().toString(); // 역순으로 추가했으므로 뒤집기
    }

    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCAB";

        // LCS 길이 계산
        int[][] dp = computeLCSLength(X, Y);
        int lcsLength = dp[X.length()][Y.length()];
        System.out.println("최장 공통 부분 수열의 길이: " + lcsLength);

        // LCS 문자열 복원
        String lcs = reconstructLCS(X, Y, dp);
        System.out.println("최장 공통 부분 수열: " + lcs);
    }
}
