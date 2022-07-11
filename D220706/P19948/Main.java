import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 음유시인 영재
 * https://www.acmicpc.net/problem/19948
 * 구현
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D220706/P19948/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        int spaceCount = Integer.parseInt(br.readLine());
        int[] alphabetCount = new int[26];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 26; i++) {
            alphabetCount[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            char c;
            for(int i = 0; i < word.length(); i++) {
                c = word.charAt(i);
                int idx = c - 'A';
                if (idx > 26) {
                    idx -= 'a' - 'A';
                }
                if (i == 0) {
                    sb.append(word.charAt(0));
                    alphabetCount[idx]--;
                }
                alphabetCount[idx]--;
                if (alphabetCount[idx] < 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(sb.toString().toUpperCase());
    }
}
