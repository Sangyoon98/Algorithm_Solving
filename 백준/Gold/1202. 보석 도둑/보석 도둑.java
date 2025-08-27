import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        int[] bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        Arrays.sort(bags);

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;
        int index = 0;

        for (int bag : bags) {
            while (index < N && arr[index][0] <= bag) {
                queue.add(arr[index][1]);
                index++;
            }

            if (!queue.isEmpty()) {
                answer += queue.poll();
            }
        }
        System.out.print(answer);
    }
}