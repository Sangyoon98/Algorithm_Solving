import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()) {
                sb.append("0 ");
                stack.push(new int[] {i, height});
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        sb.append("0 ");
                        stack.push(new int[] {i, height});
                        break;
                    }

                    int[] top = stack.peek();

                    if (top[1] > height) {
                        sb.append(top[0]).append(" ");
                        stack.push(new int[] {i, height});
                        break;
                    } else stack.pop();
                }
            }
        }

        System.out.print(sb);
    }
}