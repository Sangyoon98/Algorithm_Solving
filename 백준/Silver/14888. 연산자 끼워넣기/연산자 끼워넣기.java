import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A, operator;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        operator = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, A[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int index, int current) {
        if (index == N) {
            max = Math.max(max, current);
            min = Math.min(min, current);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                int next;
                if (i == 0) next = current + A[index];
                else if (i == 1) next = current - A[index];
                else if (i == 2) next = current * A[index];
                else next = current / A[index];

                dfs(index + 1, next);
                operator[i]++;
            }
        }
    }
}