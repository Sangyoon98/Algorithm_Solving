import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dice = new int[n][6];
        int[] opp = {5, 3, 4, 1, 2, 0};
        int answer = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 6; i++) {
            int bottom = dice[0][i];
            int sum = 0;

            for (int j = 0; j < n; j++) {
                int bottomIndex = 0;
                for (int k = 0; k < 6; k++) {
                    if (dice[j][k] == bottom) {
                        bottomIndex = k;
                        break;
                    }
                }

                int topIndex = opp[bottomIndex];
                int top = dice[j][topIndex];
                int sideMax = 0;

                for (int k = 0; k < 6; k++) {
                    if (k == bottomIndex || k == topIndex) continue;
                    sideMax = Math.max(sideMax, dice[j][k]);
                }

                sum += sideMax;
                bottom = top;
            }

            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}