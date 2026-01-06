import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int MAX = 100_000;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[MAX + 1];
        Arrays.fill(arr, -1);

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(N);
        arr[N] = 0;

        while (!deque.isEmpty()) {
            int current = deque.poll();

            if (current == K) {
                System.out.println(arr[current]);
                return;
            }

            int next = current * 2;
            if (next <= MAX && arr[next] == -1) {
                arr[next] = arr[current];
                deque.addFirst(next);
            }

            if (current - 1 >= 0 && arr[current - 1] == -1) {
                arr[current - 1] = arr[current] + 1;
                deque.addLast(current - 1);
            }

            if (current + 1 <= MAX && arr[current + 1] == -1) {
                arr[current + 1] = arr[current] + 1;
                deque.addLast(current + 1);
            }
        }
    }
}