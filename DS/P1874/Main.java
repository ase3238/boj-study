import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
 * 스택 수열
 * https://www.acmicpc.net/problem/1874
 * 구현, Stack
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("DS/P1874/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 1;
        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());
            if (target < num) {
                if (s.isEmpty() || s.peek() != target) {
                    System.out.println("NO");
                    return;
                }
                s.pop();
                sb.append("-\n");
            } else {
                while(num <= target) {
                    s.push(num);
                    num++;
                    sb.append("+\n");
                }
                s.pop();
                sb.append("-\n");
            }
        }
        System.out.println(sb);
    }
}
