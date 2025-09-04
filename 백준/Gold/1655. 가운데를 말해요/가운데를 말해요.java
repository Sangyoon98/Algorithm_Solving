import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (left.isEmpty() || num <= left.peek()) left.add(num);
            else right.add(num);

            if (left.size() > right.size() + 1) right.add(left.poll());
            else if (right.size() > left.size()) left.add(right.poll());

            sb.append(left.peek()).append("\n");
        }

        System.out.print(sb);
    }
}