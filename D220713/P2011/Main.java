import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 암호코드
 * https://www.acmicpc.net/problem/2011
 * Dynamic Programming
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D220713/P2011/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] s = (" " + br.readLine()).toCharArray();
        int N = s.length;
        if (N == 1) {
            System.out.println(0);
            return;
        }
        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int number = s[i] - '0';
            if (number > 0 && number <= 9) { // number가 0인 경우는 이전 case를 보지 않는다!
                dp[i] += dp[i - 1];
            }
            if (i == 1) continue;
            number += (s[i - 1] - '0') * 10;
            if (number >= 10 && number <= 26) {
                dp[i] += dp[i - 2];
            }
            dp[i] %= 1000000;
        }
        System.out.println(dp[N - 1]);
    }
}
