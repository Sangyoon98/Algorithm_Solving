import java.io.*;
import java.util.*;

public class Main {
    static int row = 3;
    static int col = 3;
    static int[][] A = new int[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i <= 100; i++) {
            int current = (r < row && c < col) ? A[r][c] : 0;

            if (current == k) {
                System.out.println(i);
                return;
            }

            if (i == 100) break;
            if (row >= col) operateR();
            else operateC();
        }

        System.out.println(-1);
    }

    static void operateR() {
        int[][] temp = new int[100][100];
        int nextCol = 0;

        for (int i = 0; i < row; i++) {
            int[] count = new int[101];

            for (int j = 0; j < col; j++) {
                int v = A[i][j];
                if (v == 0) continue;
                count[v]++;
            }

            ArrayList<int[]> list = new ArrayList<>();
            for (int j = 1; j <= 100; j++) {
                if (count[j] > 0) list.add(new int[] {j, count[j]});
            }

            list.sort((a, b) -> {
                if (a[1] != b[1]) return a[1] - b[1];
                return a[0] - b[0];
            });

            int index = 0;
            for (int[] p : list) {
                if (index >= 100) break;
                temp[i][index++] = p[0];
                if (index >= 100) break;
                temp[i][index++] = p[1];
            }
            nextCol = Math.max(nextCol, index);
        }

        A = temp;
        col = Math.min(100, nextCol);
    }

    static void operateC() {
        int[][] temp = new int[100][100];
        int nextRow = 0;

        for (int i = 0; i < col; i++) {
            int[] count = new int[101];

            for (int j = 0; j < row; j++) {
                int v = A[j][i];
                if (v == 0) continue;
                count[v]++;
            }

            ArrayList<int[]> list = new ArrayList<>();
            for (int j = 1;  j <= 100; j++) {
                if (count[j] > 0) list.add(new int[] {j, count[j]});
            }

            list.sort((a, b) -> {
                if (a[1] != b[1]) return a[1] - b[1];
                return a[0] - b[0];
            });

            int index = 0;
            for (int[] p : list) {
                if (index >= 100) break;
                temp[index++][i] = p[0];
                if (index >= 100) break;
                temp[index++][i] = p[1];
            }
            nextRow = Math.max(nextRow, index);
        }

        A = temp;
        row = Math.min(100, nextRow);
    }
}