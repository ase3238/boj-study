import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 괄호의 값
 * https://www.acmicpc.net/problem/2504
 * 구현, Stack, 재귀
 */
public class Main {
    static int index;
    static char[] brackets;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("DS/P2504/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        brackets = br.readLine().toCharArray();

        if (!isValid()) {
            System.out.println(0);
            return;
        }
        index = 0;
        System.out.println(calculate());
    }

    static boolean isValid() {
        Stack<Character> q = new Stack<>();
        for(char b: brackets) {
            switch (b) {
                case ')':
                    if (q.isEmpty() || q.pop() != '(') return false;
                    break;
                case ']':
                    if (q.isEmpty() || q.pop() != '[') return false;
                    break;
                default:
                    q.add(b);
            }
        }
        return q.isEmpty();
    }

    static int calculate() {
        int result = 0;
        while (index < brackets.length) {
            if (brackets[index] == '(') {
                index++;
                result += calculate() * 2;
                index++;
            } else if (brackets[index] == '[') {
                index++;
                result += calculate() * 3;
                index++;
            } else if (brackets[index] == ')') {
                if (brackets[index - 1] == '(') {
                    return 1;
                }
                return result;
            } else {
                if (brackets[index - 1] == '[') {
                    return 1;
                }
                return result;
            }
        }
        return result;
    }
}
