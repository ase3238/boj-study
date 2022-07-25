import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * 모든 순열
 * https://www.acmicpc.net/problem/10974
 * 재귀, 전체 탐색
 */
public class Main {
    static int N;
    static List<Integer> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("D220725/P10974/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N];
        list = new ArrayList<>();

        run();
    }

    static void run() {
        check();
        for (int i = 1; i <= N; i++) {
            if (!visited[i - 1]) {
                visited[i - 1] = true;
                list.add(i);
                run();
                list.remove(list.size() - 1);
                visited[i - 1] = false;
            }
        }
    }

    static void check() {
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(list.get(i));
            if (i != N - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}