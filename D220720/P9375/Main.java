import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D220720/P9375/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        HashMap<String, Integer> clothes;
        for (int k = 0; k < T; k++) {
            int N = Integer.parseInt(br.readLine());
            clothes = new HashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                Integer count = clothes.get(type);
                if (count == null) {
                    count = 0;
                }
                clothes.put(type, count + 1);
            }

            // 경우의 수는 각 종류 + 1(안입은 경우)를 곱한뒤, 안입은 경우를 빼야함.
            int result = 1;
            for (String key: clothes.keySet()) {
                result *= (clothes.get(key) + 1);
            }
            result -= 1;
            System.out.println(result);
        }
    }

}