import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());
            queue.add(new int[] { deadline, ramen });
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            heap.add(current[1]);

            if (heap.size() > current[0]) heap.poll();
        }

        int answer = 0;
        for (int value : heap) answer += value;
        System.out.println(answer);
    }
}