import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int[] S = new int[L];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());

        Arrays.sort(S);

        for (int i : S) {
            if (i == n) {
                System.out.println(0);
                return;
            }
        }

        int left = 0;
        int right = Integer.MAX_VALUE;

        for (int i : S) {
            if (i < n) left = i;
            else if (i > n) {
                right = i;
                break;
            }
        }

        System.out.println((n - left) * (right - n) - 1);
    }
}