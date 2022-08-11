import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 탑
 * https://www.acmicpc.net/problem/2493
 * 구현, 자료구조
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("DS/P2493/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tower = new int[N + 1];
        int[] result = new int[N + 1];
        tower[0] = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            tower[i] = Integer.parseInt(st.nextToken());
            if (tower[i] > tower[i - 1]) {
                int before = result[i - 1];
                while (tower[i] > tower[before]) {
                    before = result[before];
                }
                result[i] = before;
            } else {
                result[i] = i - 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]);
            sb.append(' ');
        }
        System.out.println(sb);
    }
}
