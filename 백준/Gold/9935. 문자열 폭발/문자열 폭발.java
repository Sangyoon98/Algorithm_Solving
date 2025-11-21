import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char c : str) {
            stack.add(c);

            if (stack.size() >= bomb.length) {
                boolean isMatch = true;
                for (int i = 0; i < bomb.length; i++) {
                    if (stack.get(stack.size() - bomb.length + i) != bomb[i]) {
                        isMatch = false;
                        break;
                    }
                }

                if (isMatch) {
                    for (int i = 0; i < bomb.length; i++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) sb.append(c);
            System.out.println(sb);
        }
    }
}