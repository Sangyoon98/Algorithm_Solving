import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int answer = check();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N && arr[i][j] != arr[i][j + 1]) {
                    swap(i, j, i, j + 1);
                    answer = Math.max(answer, check());
                    swap(i, j, i, j + 1);
                }

                if (i + 1 < N && arr[i][j] != arr[i + 1][j]) {
                    swap(i, j, i + 1, j);
                    answer = Math.max(answer, check());
                    swap(i, j, i + 1, j);
                }
            }
        }

        System.out.println(answer);
    }

    public static void swap(int x1, int y1, int x2, int y2) {
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    public static int check() {
        int best = 1;

        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (arr[i][j] == arr[i][j - 1]) count++;
                else count = 1;
                if (count > best) best = count;
            }
        }

        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 1; i < N; i++) {
                if (arr[i][j] == arr[i - 1][j]) count++;
                else count = 1;
                if (count > best) best = count;
            }
        }

        return best;
    }
}