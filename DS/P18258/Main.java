import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 큐 2
 * https://www.acmicpc.net/problem/18258
 * Queue, Deque, 구현
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("DS/P18258/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Deque<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push":
                    q.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(q.isEmpty() ? -1 : q.poll());
                    break;
                case "size":
                    sb.append(q.size());
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    sb.append(q.isEmpty() ? -1 : q.peekFirst());
                    break;
                case "back":
                    sb.append(q.isEmpty() ? -1 : q.peekLast());
                    break;
            }
            if (!cmd.equals("push")) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}