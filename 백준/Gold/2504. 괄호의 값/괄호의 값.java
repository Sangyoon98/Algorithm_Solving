import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int sum = 1;

        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                stack.push(str[i]);
                sum *= 2;
            } else if (str[i] == '[') {
                stack.push(str[i]);
                sum *= 3;
            } else if (str[i] == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                } else if (str[i - 1] == '(') result += sum;
                stack.pop();
                sum /= 2;
            } else if (str[i] == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                } else if (str[i - 1] == '[') result += sum;
                stack.pop();
                sum /= 3;
            }
        }

        System.out.print(stack.isEmpty() ? result : 0);
    }
}