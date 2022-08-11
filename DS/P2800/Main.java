import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
 * 괄호 제거
 * https://www.acmicpc.net/problem/2800
 * 구현, Stack
 */
public class Main {
    static ArrayList<Integer[]> bracket;
    static Set<String> expSet;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("DS/P2800/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] exp = br.readLine().toCharArray();
        bracket = new ArrayList<>();
        Stack<Integer[]> bracketStack = new Stack<>();
        for (int i = 0; i < exp.length; i++) {
            if (exp[i] == '(') {
                Integer[] pos = new Integer[2];
                pos[0] = i;
                bracketStack.push(pos);
            } else if (exp[i] == ')') {
                Integer[] pos = bracketStack.pop();
                pos[1] = i;
                bracket.add(pos);
            }
        }

        expSet = new HashSet<>();
        addResult(0, exp);
        ArrayList<String> list = new ArrayList<>(expSet);
        list.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        for(String r: list) {
            sb.append(r);
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void addResult(int index, char[] exp) {
        if (index == bracket.size()) {
            boolean flag = false;
            StringBuilder sb = new StringBuilder();
            for(char e: exp) {
                if (e == '\0') {
                    flag = true;
                    continue;
                }
                sb.append(e);
            }
            if (flag) {
                expSet.add(sb.toString());
            }
            return;
        }
        for (int i = index; i < bracket.size(); i++) {
            exp[bracket.get(i)[0]] = '\0';
            exp[bracket.get(i)[1]] = '\0';
            addResult(i + 1, exp);
            exp[bracket.get(i)[0]] = '(';
            exp[bracket.get(i)[1]] = ')';
        }
        addResult(index + 1, exp);
    }
}
