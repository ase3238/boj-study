import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Balloon {
    int index;
    int number;

    Balloon(int index, int number) {
        this.index = index;
        this.number = number;
    }
}

public class MainDeque {
    public static void solution(String[] args) throws IOException {
        System.setIn(new FileInputStream("DS/P2346/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Balloon> q = new LinkedList<>();
        for (int i = 1; i <= N; i++){
            q.add(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        int move = 0;
        boolean way = true; // true - right, false - left
        while(!q.isEmpty()) {
            while (move != 0) {
                if (way)  q.addLast(q.pollFirst());
                else q.addFirst(q.pollLast());
                move--;
            }
            Balloon curr = way ? q.pollFirst() : q.pollLast();
            sb.append(curr.index);
            sb.append(" ");
            move = Math.abs(curr.number) - 1;
            way = curr.number > 0;
        }
        System.out.println(sb);
    }
}
