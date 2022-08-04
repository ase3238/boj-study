import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
 * 스택
 * https://www.acmicpc.net/problem/10828
 * Stack, 구현
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("DS/P10828/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int size = 0;
        int[] list = new int[10000];
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("push")) {
                list[size++] = Integer.parseInt(st.nextToken());
            } else if (cmd.equals("pop")) {
                sb.append(size == 0 ? -1 :list[--size]);
                sb.append("\n");
            } else if (cmd.equals("size")) {
                sb.append(size);
                sb.append("\n");
            } else if (cmd.equals("empty")) {
                sb.append(size == 0 ? 1 : 0);
                sb.append("\n");
            } else if (cmd.equals("top")) {
                sb.append(size == 0 ? -1 :list[size - 1]);
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
