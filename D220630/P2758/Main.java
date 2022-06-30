/*
 * 로또
 * https://www.acmicpc.net/problem/2758
 * DP
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D220630/P2758/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            System.out.println(solution(N,M));
        }
    }

    public static long solution(int N, int M) {
        long[][] dp = new long[N + 1][M + 1];

        for (int i = 0; i <= M; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                // dp[i-1][j/2] -> j를 고르는 경우. (왜냐면 i-1번째 숫자가 j/2이니까!)
                // dp[i][j - 1] -> j를 고르지 않는 경우. (이전꺼 기준으로 체크를 함)
                dp[i][j] = dp[i - 1][j / 2] + dp[i][j - 1];
            }
        }
        return dp[N][M];
    }    
}
