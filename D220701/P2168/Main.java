import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 타일 위의 대각선
 * https://www.acmicpc.net/problem/2168
 * 유클리드 호제법
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D220701/P2168/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long p = Long.parseLong(st.nextToken());
        long q = Long.parseLong(st.nextToken());
        long gcd = getGcd(p, q);
        long cop = p / gcd;
        long coq = q / gcd;
        System.out.println((cop + coq - 1) * gcd);
    }

    public static long getGcd(long p, long q) {
        long r = p % q;
        while (r > 0) {
            p = q;
            q = r;
            r = p % q;
        }
        return q;
    }
}
