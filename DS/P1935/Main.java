import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 후위 표기식
 * https://www.acmicpc.net/problem/1935
 * 구현, Stack
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("DS/P1935/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] exp = br.readLine().toCharArray();
        double[] numbers = new double[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> s = new Stack<>();
        for (char e: exp) {
            if (e >= 'A' && e <= 'Z') {
                s.push(numbers[e - 'A']);
            } else {
                double b = s.pop();
                double a = s.pop();
                if (e == '+') {
                    s.push(a + b);
                } else if (e == '-') {
                    s.push(a - b);
                } else if (e == '*') {
                    s.push(a * b);
                } else if (e == '/') {
                    s.push(a / b);
                }
            }
        }
        System.out.printf("%.2f\n", s.pop());
    }
}
