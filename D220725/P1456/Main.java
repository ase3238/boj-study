import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 거의 소수
 * https://www.acmicpc.net/problem/1456
 * 순열, 재귀
 */
public class Main {
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("D220725/P1456/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double N = Double.parseDouble(st.nextToken());
        double M = Double.parseDouble(st.nextToken());

        double rootM = Math.sqrt(M);
        boolean[] isNotPrime = new boolean[(int) (rootM + 1)];
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        int count = 0;
        for (int i = 2; i < isNotPrime.length; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * 2; j < isNotPrime.length; j += i) {
                    isNotPrime[j] = true;
                }
                // 거의소수 판별법 수정필요...
                double max = Math.floor(Math.log(M) / Math.log(i));
                double min = Math.ceil(Math.log(N) / Math.log(i));
                if (min <= max) {
                    count += max - min + 1;
                }
            }
        }

        System.out.println(count);
    }
}