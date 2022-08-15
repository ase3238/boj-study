import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * 나는야 포켓몬 마스터 이다솜
 * https://www.acmicpc.net/problem/1620
 * HashMap
 */
public class Main {
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("DS2/P1620/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] iToS = new String[N + 1];
        Map<String, Integer> sToI = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            iToS[i] = br.readLine();
            sToI.put(iToS[i], i);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String question = br.readLine();
            try {
                int num = Integer.parseInt(question);
                sb.append(iToS[num]);
            } catch (NumberFormatException e) {
                sb.append(sToI.get(question));
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
