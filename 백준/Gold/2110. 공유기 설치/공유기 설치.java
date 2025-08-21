import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int low = 1;
        int high = arr[N - 1] - arr[0];
        int answer = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (can(mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean can(int value) {
        int count = 1;
        int prev = arr[0];

        for (int i = 0; i < N; i++) {
            if (arr[i] - prev >= value) {
                count++;
                prev = arr[i];
                if (count >= C) return true;
            }
        }
        return false;
    }
}