import java.io.*;
import java.util.*;

public class Main {
    static int N, L;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            int[] row = new int[N];
            for (int j = 0; j < N; j++) row[j] = map[i][j];
            if (isPass(row)) answer++;
        }

        for (int i = 0; i < N; i++) {
            int[] col = new int[N];
            for (int j = 0; j < N; j++) col[j] = map[j][i];
            if (isPass(col)) answer++;
        }

        System.out.println(answer);
    }

    static boolean isPass(int[] arr) {
        boolean[] runway = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int current = arr[i];
            int next = arr[i + 1];

            // 평지
            if (current == next) continue;

            // 높이차 1 이상
            if (Math.abs(current - next) != 1) return false;

            // 오르막
            if (next == current + 1) {
                for (int j = 0; j < L; j++) {
                    int index = i - j;
                    if (index < 0) return false;
                    if (arr[index] != current) return false;
                    if (runway[index]) return false;
                }
                for (int j = 0; j < L; j++) runway[i - j] = true;
            } else {    // 내리막
                for (int j = 1; j <= L; j++) {
                    int index = i + j;
                    if (index >= N) return false;
                    if (arr[index] != next) return false;
                    if (runway[index]) return false;
                }
                for (int j = 1; j <= L; j++) runway[i + j] = true;
            }
        }
        return true;
    }
}