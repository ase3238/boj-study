import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 쇠막대기
 * https://www.acmicpc.net/problem/10799
 * 구현, Stack
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("DS/P10799/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] brackets = br.readLine().toCharArray();

        Stack<Integer> s = new Stack<>();
        int count = 0;
        for (int i = 0; i < brackets.length; i++) {
            if (brackets[i] == '(') {
                s.push(i);
            } else {
                if (s.pop() + 1 == i) { // 레이저인 경우
                    count += s.size(); // stack에 있는 개수만큼 잘라냄
                } else { // 그냥 닫는 경우
                    count += 1; // 막대기의 꼬다리를 추가
                }
            }
        }
        System.out.println(count);
    }
}
