/*
 * 스위치와 램프
 * https://www.acmicpc.net/problem/16960
 * 구현
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D220630/P16960/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] lampCount = new int[M + 1];
        List<Integer>[] lampSwitch = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            lampSwitch[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int idx = Integer.parseInt(st.nextToken());
                lampSwitch[i].add(idx);
                lampCount[idx]++;
            }
        }

        for (int i = 1; i <= N; i++) {
            boolean flag = false;
            for(int idx: lampSwitch[i]) {
                if (lampCount[idx] == 1) {
                    flag = true;
                }
                if (flag) {
                    break;
                }
            }
            if (flag) {
                continue;
            } else {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
        return;
    }
}