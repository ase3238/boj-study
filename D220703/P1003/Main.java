import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치 함수
 * https://www.acmicpc.net/problem/1003
 * Dynamic Programming
 */
public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D220703/P1003/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            // 0 1 2 3 4 5 6 7 8 9 10
            // 1 0 1 1 2
            // 0 1 1 2 3
            int N = Integer.parseInt(br.readLine());
            dp = new int[N + 2][2]; // OutOfBound 나올수 있어서 + 2를 해줌.

            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[1][0] = 0;
            dp[1][1] = 1;
            for (int j = 2; j <= N; j++) {
                dp[j][0] = dp[j - 1][0] + dp[j - 2][0];
                dp[j][1] = dp[j - 1][1] + dp[j - 2][1];
            }
            StringBuilder sb = new StringBuilder();
            sb.append(dp[N][0]);
            sb.append(" ");
            sb.append(dp[N][1]);
            System.out.println(sb);
        }
    }
}