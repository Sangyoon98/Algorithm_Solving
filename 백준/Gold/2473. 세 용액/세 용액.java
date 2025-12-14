import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        long best = Long.MAX_VALUE;
        long a = 0, b = 0, c = 0;

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];
                long abs = Math.abs(sum);

                if (abs < best) {
                    best = abs;
                    a = arr[i];
                    b = arr[left];
                    c = arr[right];
                }

                if (sum > 0) right--;
                else left++;
            }
        }
        System.out.println(a + " " + b + " " + c);
    }
};