import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

/* 
 * 두 개의 배열
 * https://www.acmicpc.net/problem/17124
 * 이진 탐색
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D220717/P17124/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int k = 0; k < T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer> B = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B.add(Integer.parseInt(st.nextToken()));
            }

            B.sort(Comparator.naturalOrder());

            int result = 0;
            for (int i = 0; i < N; i++) {
                result += bst(A[i], B);
            }
            System.out.println(result);
        }
    }

    static int bst(int a, ArrayList<Integer> B) {
        int min = 0;
        int max = B.size() - 1;
        while (true) {
            if (max - min == 1) {
                break;
            }
            int mid = (min + max) / 2;
            int data = B.get(mid);
            if (a < data) {
                max = mid;
            } else if (a > data) {
                min = mid;
            } else {
                return data;
            }
        }
        int maxVal = B.get(max);
        int minVal = B.get(min);
        if (maxVal - a < a - minVal) {
            return maxVal;
        } else {
            return minVal;
        }
    }
}
