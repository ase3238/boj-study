import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 생태학
 * https://www.acmicpc.net/problem/4358
 * 구현, Map, 정렬
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("DS2/P4358/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = 0;
        String tree;
        Map<String, Integer> map = new HashMap<>();
        while ((tree = br.readLine()) != null) {
            map.put(tree, map.containsKey(tree) ? map.get(tree) + 1 : 1);
            total++;
        }

        List<String> keys = new ArrayList<>(map.keySet());
        keys.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        for (String key: keys) {
            sb.append(key);
            sb.append(' ');
            sb.append(String.format("%.4f", (double) map.get(key) / total * 100));
            sb.append('\n');            
        }
        System.out.print(sb);
    }
}
