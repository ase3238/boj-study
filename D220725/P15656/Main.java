import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/*
 * N과 M (7)
 * https://www.acmicpc.net/problem/15656
 * 순열, 재귀
 */
public class Main {
    static int N, M;
    static List<Integer> candidate, selected;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("D220725/P15656/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        candidate = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            candidate.add(Integer.parseInt(st.nextToken()));
        }
        candidate.sort(Comparator.naturalOrder());

        selected = new ArrayList<>();
        sb = new StringBuilder();
        select(0);
        System.out.print(sb);
    }

    static void select(int count) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected.get(i));
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            selected.add(candidate.get(i));
            select(count + 1);
            selected.remove(selected.size() - 1);
        }
    }
}