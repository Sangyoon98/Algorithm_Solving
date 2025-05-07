import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arrA = new int[N];
            int[] arrB = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arrA[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) arrB[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arrB);
            int result = 0;

            for (int i = 0; i < N; i++) {
                int min = 0;
                int max = M - 1;

                while (min <= max) {
                    int mid = (min + max) / 2;
                    if (arrA[i] <= arrB[mid]) max = mid - 1;
                    else min = mid + 1;
                }
                result += min;
            }
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}