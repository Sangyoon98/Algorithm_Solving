import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] pick;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        pick = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int index, int count) {
        if (count == N / 2) {
            int start = 0;
            int link = 0;

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (pick[i] && pick[j]) start += S[i][j] + S[j][i];
                    else if (!pick[i] && !pick[j]) link += S[i][j] + S[j][i];
                }
            }

            answer = Math.min(answer, Math.abs(start - link));
        }

        for (int i = index; i < N; i++) {
            pick[i] = true;
            dfs(i + 1, count + 1);
            pick[i] = false;
        }
    }
}