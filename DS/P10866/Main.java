import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 덱
 * https://www.acmicpc.net/problem/10866
 * 구현, Deque
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("DS/P10866/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Deque<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push_front":
                    q.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    q.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(q.isEmpty() ? -1 : q.pollFirst());
                    break;
                case "pop_back":
                    sb.append(q.isEmpty() ? -1 : q.pollLast());
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
            if (!cmd.equals("push_front") && !cmd.equals("push_back")) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}