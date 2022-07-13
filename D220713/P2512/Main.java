import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 예산
 * https://www.acmicpc.net/problem/2512
 * Parametric Search
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D220713/P2512/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] budget = new int[N];
        long sum = 0;
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            sum += budget[i];
            max = Math.max(max, budget[i]);
        }
        long M = Long.parseLong(br.readLine());
        if (sum <= M) {
            System.out.println(max);
            return;
        }

        int min = 0;
        int answer = -1;
        while (min <= max) {
            int mid = (min + max) / 2;
            sum = 0;
            for (int i = 0; i < N; i++) {
                sum += Math.min(mid, budget[i]);
            }
            if (sum <= M) {
                answer = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(answer);
        return;
    }
    
}