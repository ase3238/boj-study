import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 만약 영역이 겹치는구간으로 한다면 이 방식으로
 */
public class MainAreatype {
    static class Circle {
        int left;
        int right;

        Circle(int left, int right) {
            this.left = left;
            this.right = right;
        }

        int getLeft() {
            return this.left;
        }

        int getRight() {
            return this.right;
        }
    }
    public static void solution(String[] args) throws IOException {
        System.setIn(new FileInputStream("DS/P22942/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Circle[] list = new Circle[N];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            list[i] = new Circle(x - r, x + r);
            min = Math.min(min, x - r);
            max = Math.max(max, x + r);
        }

        Arrays.sort(list, Comparator.comparing(Circle::getLeft));
        PriorityQueue<Circle> pq = new PriorityQueue<>(Comparator.comparing(Circle::getRight));
        int idx = 0;
        for (int i = min; i <= max; i++) {
            if (idx == N) {
                break;
            }
            while (list[idx].left == i && idx < N) {
                pq.add(list[idx]);
                idx++;
            }
            while (pq.peek().right < i) {
                pq.poll();
            }
            if (pq.size() > 1) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
