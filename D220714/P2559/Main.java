import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 수열
 * https://www.acmicpc.net/problem/2559
 * 부분합, 슬라이딩 윈도우
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D220714/P2559/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            if (i < K) {
                sum += numbers[i];
            }
        }
        
        int max = sum;
        for (int i = K; i < N; i++) {
            sum = sum + numbers[i] - numbers[i - K];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
