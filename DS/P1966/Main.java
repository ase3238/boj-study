import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 프린터 큐
 * https://www.acmicpc.net/problem/1966
 * 구현, 정렬, Queue
 */
class Paper {
    int index;
    int priority;
    Paper(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("DS/P1966/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int k = 0; k < T; k++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<Paper> q = new LinkedList<>();
            Integer[] priority = new Integer[N];
            for (int i = 0; i < N; i++) {
                priority[i] = Integer.parseInt(st.nextToken());
                q.add(new Paper(i, priority[i]));
            }

            Arrays.sort(priority, Comparator.reverseOrder());
            int count = 0;
            for (int i = 0; i < N; i++) {
                while(q.peek().priority != priority[i]) {
                    q.add(q.poll());
                }
                count++;
                if (q.poll().index == M) {
                    System.out.println(count);
                    break;
                }
            }
        }
    }
}
