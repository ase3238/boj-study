import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D220717/P3085/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swapRow(i, j);
                result = Math.max(result, count());
                swapRow(i, j);

                swapCol(i, j);
                result = Math.max(result, count());
                swapCol(i, j);
            }
        }
        System.out.println(result);
    }

    static void swapRow(int i, int j) {
        char temp = map[i][j];
        map[i][j] = map[i][j + 1];
        map[i][j + 1] = temp;
    }

    static void swapCol(int i, int j) {
        char temp = map[j][i];
        map[j][i] = map[j + 1][i];
        map[j + 1][i] = temp;
    }

    static int count() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (map[i][j] == map[i][j + 1]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (map[j][i] == map[j + 1][i]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
