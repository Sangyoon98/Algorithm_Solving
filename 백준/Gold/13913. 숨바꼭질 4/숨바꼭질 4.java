import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dist = new int[100001];
        int[] prev = new int[100001];
        Arrays.fill(dist, -1);
        Arrays.fill(prev, -1);

        Deque<Integer> queue = new LinkedList<>();
        queue.add(N);
        dist[N] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == K) break;

            int[] next = {current - 1, current + 1, current * 2};

            for (int n : next) {
                if (n < 0 || n > 100000) continue;
                if (dist[n] != -1) continue;
                dist[n] = dist[current] + 1;
                prev[n] = current;
                queue.add(n);
            }
        }

        ArrayList<Integer> path = new ArrayList<>();
        for (int current = K; current != -1; current = prev[current]) {
            path.add(current);
        }
        Collections.reverse(path);

        StringBuilder sb = new StringBuilder();
        sb.append(dist[K]).append("\n");
        for (Integer p : path) {
            sb.append(p).append(" ");
        }

        System.out.println(sb);
    }
}