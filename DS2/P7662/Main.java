import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 이중 우선순위 큐
 * https://www.acmicpc.net/problem/7662
 * Priority Queue, 구현
 */
public class Main {
    static class Number {
        int number;
        boolean isDeleted;
        Number(int number) {
            this.number = number;
            this.isDeleted = false;
        }
        int getNumber() {
            return this.number;
        }
        void delete() {
            this.isDeleted = true;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("DS2/P7662/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        Queue<Number> minQ, maxQ;
        int size;
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < T; c++) {
            int k = Integer.parseInt(br.readLine());
            minQ = new PriorityQueue<>(Comparator.comparingInt(Number::getNumber));
            maxQ = new PriorityQueue<>(Comparator.comparingInt(Number::getNumber).reversed());
            size = 0;
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int n = Integer.parseInt(st.nextToken());
                if (op.equals("I")) {
                    Number number = new Number(n);
                    minQ.add(number);
                    maxQ.add(number);
                    size++;
                } else if(size > 0) {
                    if (n == -1) {
                        minQ.poll().delete();
                        size--;
                    } else {
                        maxQ.poll().delete();
                        size--;
                    }
                    while(!minQ.isEmpty() && minQ.peek().isDeleted) {
                        minQ.poll();
                    }
                    while(!maxQ.isEmpty() && maxQ.peek().isDeleted) {
                        maxQ.poll();
                    }
                }
            }

            if (size == 0) {
                sb.append("EMPTY\n");
            } else {
                sb.append(maxQ.poll().number);
                sb.append(' ');
                sb.append(minQ.poll().number);
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}
