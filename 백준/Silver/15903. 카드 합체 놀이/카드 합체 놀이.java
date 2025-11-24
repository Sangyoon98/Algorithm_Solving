import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> queue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        long result = 0;

        for (int i = 0; i < n; i++) {
            queue.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            if (queue.size() >= 2) {
                long x = queue.poll();
                long y = queue.poll();
                queue.add(x + y);
                queue.add(x + y);
            }
        }

        while (!queue.isEmpty()) {
            result += queue.poll();
        }

        System.out.print(result);
    }
}