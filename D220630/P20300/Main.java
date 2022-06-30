/*
 * 서강근육맨
 * https://www.acmicpc.net/problem/20300
 * Greedy Algorithm
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D220630/P20300/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> spq = new PriorityQueue<>(Comparator.naturalOrder());
        PriorityQueue<Long> lpq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            long curr = Long.parseLong(st.nextToken());
            spq.add(curr);
            lpq.add(curr);
        }

        long max = 0;
        if (N % 2 == 1) {
            max = lpq.poll();
        }
        for (int i = 0; i < N/2; i++) {
            long curr = spq.poll() + lpq.poll();
            max = Math.max(max, curr);
        }
        System.out.println(max);
    }
}
