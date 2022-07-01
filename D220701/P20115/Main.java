import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 에너지 드링크
 * https://www.acmicpc.net/problem/20115
 * Greedy Algorithm
 */
public class Main {
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("D220701/P20115/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long sum = 0;
        long max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(st.nextToken());
            max = Math.max(max, num);
            sum += num;
        }
        System.out.println((double)(sum - max) / 2 + max);
    }
}