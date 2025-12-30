import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int a1 = 0, a2 = 0, a3 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0, 0, N);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
    }

    static void cut(int x, int y, int size) {
        if (isSame(x, y, size)) {
            switch (arr[x][y]) {
                case -1:
                    a1++;
                    break;
                case 0:
                    a2++;
                    break;
                case 1:
                    a3++;
                    break;
            }
            return;
        }

        int n = size / 3;
        for (int dx = 0; dx < 3; dx++) {
            for (int dy = 0; dy < 3; dy++) {
                cut(x + dx * n, y + dy * n, n);
            }
        }
    }

    static boolean isSame(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != arr[x][y]) return false;
            }
        }
        return true;
    }
}