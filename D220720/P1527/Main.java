import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
 * 금민수의 개수
 * https://www.acmicpc.net/problem/1527
 * BFS
 */
public class Main {
    static long start, end;
    static int result;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D220720/P1527/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Long.parseLong(st.nextToken());
        end = Long.parseLong(st.nextToken());

        result = 0;
        dfs(4l);
        dfs(7l);
        System.out.println(result);
    }

    static void dfs(Long number) {
        if (number > end) {
            return;
        } else if (number >= start && number <= end) {
            result++;
        }
        dfs(number * 10 + 4);
        dfs(number * 10 + 7);
    }
}
