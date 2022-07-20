import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 수 묶기
 * https://www.acmicpc.net/problem/1744
 * 구현, 정렬, 조건처리
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D220720/P1744/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> positiveQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> negativeQueue = new PriorityQueue<>(Comparator.naturalOrder());
        int result = 0;
        int zeroCount = 0;
        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 1) {
                result++;
            } else if (number == 0) {
                zeroCount++;
            } else if (number > 1) {
                positiveQueue.add(number);
            } else {
                negativeQueue.add(number);
            }
        }
        
        while(positiveQueue.size() > 1) {
            result += positiveQueue.poll() * positiveQueue.poll();
        }
        if (!positiveQueue.isEmpty()) {
            result += positiveQueue.poll();
        }
        while(negativeQueue.size() > 1) {
            result += negativeQueue.poll() * negativeQueue.poll();
        }
        if (!negativeQueue.isEmpty() && zeroCount == 0) {
            result += negativeQueue.poll();
        }

        System.out.println(result);
    }
}
