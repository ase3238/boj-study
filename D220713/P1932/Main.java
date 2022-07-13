import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 정수 삼각형
 * https://www.acmicpc.net/problem/1932
 * Dynamic Programming
 *  - 이전에 풀은적 있던 문제임.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D220713/P1932/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][N];

        dp[0][0] = Integer.parseInt(br.readLine());
        int max = dp[0][0];
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + num;
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + num;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + num;
                }
                if (i == N - 1) {
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        System.out.println(max);
    }
}
