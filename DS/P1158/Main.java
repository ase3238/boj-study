import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 요세푸스 문제
 * https://www.acmicpc.net/problem/1158
 * 구현, Queue
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("DS/P1158/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        
        sb.append("<");
        boolean isFirst = true;
        while(!q.isEmpty()) {
            for (int i = 1; i <= K; i++) {
                if (i == K) {
                    if (!isFirst) sb.append(", ");
                    sb.append(q.poll());
                    isFirst = false;
                } else {
                    q.add(q.poll());
                }
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
