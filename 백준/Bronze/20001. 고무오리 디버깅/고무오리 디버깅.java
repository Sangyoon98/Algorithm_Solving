import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        
        while (true) {
            String str = br.readLine();

            if (str.equals("고무오리 디버깅 시작")) continue;
            else if (str.equals("문제")) stack.add("문제");
            else if (str.equals("고무오리")) {
                if (stack.isEmpty()) {
                    stack.add("문제");
                    stack.add("문제");
                } else stack.pop();
            } else if (str.equals("고무오리 디버깅 끝")) break;
        }

        System.out.print(stack.isEmpty() ? "고무오리야 사랑해" : "힝구");
    }
}