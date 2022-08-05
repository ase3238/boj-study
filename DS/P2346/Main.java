import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 풍선 터뜨리기
 * https://www.acmicpc.net/problem/2346
 * 구현, Deque
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("DS/P2346/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] balloons = new int[N];
        boolean[] isUsed = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            balloons[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int index = 0, move = 0;
        boolean way = true; // true - right, false - left
        while(!isFin(isUsed)) {
            while (move != 0) {
                index += way ? 1 : -1;
                if (index >= N) index -= N;
                else if (index < 0) index += N;
                if (isUsed[index]) continue;
                move--;
            }
            sb.append(index + 1);
            sb.append(" ");
            isUsed[index] = true;
            move = Math.abs(balloons[index]);
            way = balloons[index] > 0;
        }
        System.out.println(sb);
    }

    static boolean isFin(boolean[] isUsed) {
        for (boolean u: isUsed) {
            if (!u) {
                return false;
            }
        }
        return true;
    }
}
