import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 전구와 스위치
 * https://www.acmicpc.net/problem/2138
 * Greedy Algorithm
 */
public class Main {
    static int N;
    static boolean[] bulb;
    static boolean[] result;
    static int count;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D220703/P2138/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = new boolean[N];
        String input = br.readLine();
        String output = br.readLine();
        for (int i = 0; i < N; i++) {
            result[i] = input.charAt(i) != output.charAt(i);
        }
        
        run(false);
        if (count == -1) {
            run(true);
        }
        
        System.out.println(count);
    }

    public static void run(boolean onFirst) {
        bulb = new boolean[N];
        count = 0;
        if (onFirst) {
            bulb[0] = true;
            bulb[1] = true;
            count++;
        }
        for (int i = 1; i < N - 1; i++) {
            if (bulb[i - 1] != result[i - 1]) {
                bulb[i - 1] = !bulb[i - 1];
                bulb[i] = !bulb[i];
                bulb[i + 1] = !bulb[i + 1];
                count++;
            }
        }
        if (bulb[N - 2] != result[N - 2]) {
            bulb[N - 2] = !bulb[N - 2];
            bulb[N - 1] = !bulb[N - 1];
            count++;
        }
        if (!check()) {
            count = -1;
        }
    }

    public static boolean check() {
        for (int i = 0; i < N; i++) {
            if (bulb[i] != result[i]) {
                return false;
            }
        }
        return true;
    }
}
