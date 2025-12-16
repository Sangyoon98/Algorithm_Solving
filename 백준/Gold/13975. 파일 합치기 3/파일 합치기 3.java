import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> queue = new PriorityQueue<>();

            for (int j = 0; j < K; j++) {
                queue.add(Long.parseLong(st.nextToken()));
            }

            long answer = 0;

            while (queue.size() > 1) {
                long a = queue.poll();
                long b = queue.poll();
                long sum = a + b;
                answer += sum;
                queue.add(sum);
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}