import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        compress(0, 0, N);
        System.out.println(sb);
    }

    static void compress(int x, int y, int size) {
        if (isSame(x, y, size)) {
            sb.append(arr[x][y]);
            return;
        }

        sb.append("(");
        int half = size / 2;
        compress(x, y, half);
        compress(x, y + half, half);
        compress(x + half, y, half);
        compress(x + half, y + half, half);
        sb.append(")");
    }

    static boolean isSame(int x, int y, int size) {
        int value = arr[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) return false;
            }
        }

        return true;
    }
}