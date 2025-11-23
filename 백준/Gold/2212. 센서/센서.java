import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] gap = new int[N - 1];
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 1; i < N; i++) {
            gap[i - 1] = arr[i] - arr[i - 1];
        }

        Arrays.sort(gap);

        for (int i = 0; i < N - K; i++) {
            answer += gap[i];
        }

        System.out.print(answer);
    }
}