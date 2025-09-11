import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static List<int[]> homes = new ArrayList<>();
    static List<int[]> shops = new ArrayList<>();
    static int[] pick;
    static int best = Integer.MAX_VALUE;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) homes.add(new int[] {i, j});
                else if (map[i][j] == 2) shops.add(new int[] {i, j});
            }
        }

        dist = new int[homes.size()][shops.size()];
        for (int i = 0; i < homes.size(); i++) {
            int hx = homes.get(i)[0];
            int hy = homes.get(i)[1];
            for (int j = 0; j < shops.size(); j++) {
                int sx = shops.get(j)[0];
                int sy = shops.get(j)[1];
                dist[i][j] = Math.abs(hx - sx) + Math.abs(hy - sy);
            }
        }

        pick = new int[M];
        comb(0, 0);

        System.out.println(best);
    }

    static void comb(int index, int start) {
        if (index == M) {
            int total = 0;
            for (int i = 0; i < homes.size(); i++) {
                int minDistance = Integer.MAX_VALUE;
                for (int j = 0; j < M; j++) {
                    int shortIndex = pick[j];
                    minDistance = Math.min(minDistance, dist[i][shortIndex]);
                    if (minDistance == 0) break;
                }
                total += minDistance;
                if (total >= best) return;
            }
            best = Math.min(best, total);
            return;
        }

        for (int i = start; i < shops.size(); i++) {
            pick[index] = i;
            comb(index + 1, i + 1);
        }
    }
}