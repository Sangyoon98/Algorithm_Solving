import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        long answer = 0;

        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            int temp = a + b;
            answer += temp;
            queue.add(temp);
        }

        System.out.println(answer);
    }
}