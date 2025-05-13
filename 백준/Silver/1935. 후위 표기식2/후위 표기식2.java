import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Double> stack = new Stack<>();
        char[] suffix = br.readLine().toCharArray();
        int[] alpha = new int[N];

        for (int i = 0; i < N; i++) alpha[i] = Integer.parseInt(br.readLine());

        double answer = 0;

        for (char c : suffix) {
            if (c == '+') {
                answer = stack.pop() + stack.pop();
                stack.push(answer);
            } else if (c == '-') {
                double a = stack.pop();
                double b = stack.pop();
                answer = b - a;
                stack.push(answer);
            } else if (c == '*') {
                answer = stack.pop() * stack.pop();
                stack.push(answer);
            } else if (c == '/') {
                double a = stack.pop();
                double b = stack.pop();
                answer = b / a;
                stack.push(answer);
            } else stack.push((double) alpha[c - 'A']);
        }

        System.out.printf("%.2f", answer);
    }
}