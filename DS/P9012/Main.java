import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 괄호
 * https://www.acmicpc.net/problem/9012
 * Stack, 구현
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("DS/P9012/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            char[] bracket = br.readLine().toCharArray();
            if (bracket.length % 2 == 1) {
                sb.append("NO\n");
                continue;
            }

            int count = 0;
            for (char b: bracket) {
                if (b == '(') {
                    count++;
                } else {
                    count--;
                }
                if (count < 0) {
                    break;
                }
            }
            sb.append(count == 0 ? "YES\n" : "NO\n" );
        }
        System.out.println(sb);
    }
}