import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int max = 0;
        int min = 0;
        int mid = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        int M = Integer.parseInt(br.readLine());

        while (min <= max) {
            int sum = 0;
            mid = (max + min) / 2;

            for (int i = 0; i < N; i++) {
                sum += Math.min(arr[i], mid);
            }

            if (sum <= M) min = mid + 1;
            else max = mid - 1;
        }

        System.out.print(max);
    }
}