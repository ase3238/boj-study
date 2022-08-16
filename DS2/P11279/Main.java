import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 최대 힙
 * https://www.acmicpc.net/problem/11279
 * Priotity Queue
 */
public class Main {
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("DS2/P11279/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                sb.append(pq.isEmpty() ? 0 : pq.poll());
                sb.append('\n');
            } else {
                pq.add(number);
            }
        }
        System.out.print(sb);
    }
}
