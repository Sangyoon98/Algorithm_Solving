import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int min = 1;
        int max = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        while (min <= max) {
            int mid = (min + max) / 2;
            if (mid == 0) {
                max = 0;
                break;
            }
            int count = 0;

            for (int i = 0; i < N; i++) count += arr[i] / mid;
            if (M > count) max = mid - 1;
            else min = mid + 1;
        }

        System.out.print(max);
    }
}