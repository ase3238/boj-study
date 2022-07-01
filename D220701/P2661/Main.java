import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 좋은 수열
 * https://www.acmicpc.net/problem/2661
 * DFS 백트래킹
 */
public class Main {
    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("D220701/P2661/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        sb = new StringBuilder();
        dfs(0);
    }

    public static void dfs(int count) {
        if (count == N) {
            System.out.println(sb);
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            sb.append(i);

            if (isGood()) {
                dfs(count + 1);
            }

            sb.deleteCharAt(count);
        }
    }

    public static boolean isGood() {
        int length = sb.length();
        for (int i = 1; i <= length / 2; i++) {
            if (sb.substring(length - i, length).equals(sb.substring(length - (2 * i), length - i))) {
                return false;
            }
        }
        return true;
    }
}
