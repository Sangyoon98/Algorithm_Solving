import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            int index = BinarySearch(arr[i], 0, max, max + 1);
            if (index == -1) dp[max++] = arr[i];
            else dp[index] = arr[i];
        }

        System.out.print(max);
    }

    static int BinarySearch(int num, int start, int end, int size) {
        int res = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (num <= dp[mid]) {
                res = mid;
                end = mid - 1;
            } else start = mid + 1;
        }

        if (start == size) return -1;
        else return res;
    }
}