import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 후위 표기식
 * https://www.acmicpc.net/problem/1918
 * 구현, Stack
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("DS/P1918/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] expression = br.readLine().toCharArray();
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char exp: expression) {
            if('A' <= exp && exp <= 'Z') {
                answer.append(exp);
            } else if(exp == '(') {
                stack.push(exp);
            } else if(exp == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    answer.append(stack.pop()); // 괄호 나올때까지 여태까지의 연산자를 넣어줌
                }
                stack.pop(); // 괄호 제거
            } else if(exp == '*' || exp == '/') {
                while(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                    answer.append(stack.pop()); // 곱셈, 나눗셈의 연산이 우선이므로 넣어줌
                }
                stack.push(exp);
            } else if(exp == '+' || exp == '-') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    answer.append(stack.pop());
                }
                stack.push(exp);
            }
        }
        while(!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        System.out.println(answer);
    }
}
