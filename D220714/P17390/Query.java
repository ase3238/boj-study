import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * 트리를 이용해 푸는 방식. (시간초과났음 - 재귀를 쓰기때문인 듯)
 */
public class Query {
    static int[] tree;

    public static void solution(String[] args) throws IOException {
        System.setIn(new FileInputStream("D220714/P17390/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = 1;
        while(S < N) {
            S *= 2;
        }
        int Q = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.sort(Comparator.naturalOrder());

        tree = new int[S * 2];
        for (int i = 0; i < N; i++) {
            tree[i + S] = list.get(i);
        }
        for (int i = S - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            System.out.println(query(1, S, 1, left, right));
        }
    }

    static int query(int left, int right, int index, int queryLeft, int queryRight) {
        if (right < queryLeft || left > queryRight) {
            return 0;
        } else if (left >= queryLeft && right <= queryRight) {
            return tree[index];
        } else {
            int mid = (left + right) / 2;
            return query(left, mid, 2 * index, queryLeft, queryRight) + query(mid + 1, right, 2 * index + 1, queryLeft, queryRight);
        }
    }
}
