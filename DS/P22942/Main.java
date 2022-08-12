import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 데이터 체커
 * https://www.acmicpc.net/problem/22942
 * 구현, Sort, Stack
 */
public class Main {
    static class Circle {
        int id;
        int left;
        int right;

        Circle(int id, int left, int right) {
            this.id = id;
            this.left = left;
            this.right = right;
        }

        int getLeft() {
            return this.left;
        }

        int getRight() {
            return this.right;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("DS/P22942/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Circle[] leftList = new Circle[N];
        Circle[] rightList = new Circle[N];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            Circle c = new Circle(i, x - r, x + r);
            leftList[i] = c;
            rightList[i] = c;
            min = Math.min(min, x - r);
            max = Math.max(max, x + r);
        }

        Arrays.sort(leftList, Comparator.comparing(Circle::getLeft));
        Arrays.sort(rightList, Comparator.comparing(Circle::getRight));
        Stack<Integer> stack = new Stack<>();
        int leftIdx = 0;
        int rightIdx = 0;
        for (int i = min; i <= max; i++) {
            while (leftIdx < N && leftList[leftIdx].left == i) {
                stack.push(leftList[leftIdx].id);
                leftIdx++;
            }
            while (rightIdx < N && rightList[rightIdx].right == i) {
                if (stack.pop() != rightList[rightIdx].id) {
                    System.out.println("NO");
                    return;
                }
                rightIdx++;
            }
        }
        System.out.println("YES");
    }
}
