import java.io.*;
import java.util.*;

public class Main {
    static class Dice {
        int top, bottom, north, south, east, west;

        void rollEast() {
            int t = top, b = bottom, e = east, w = west;
            top = w;
            bottom = e;
            east = t;
            west = b;
        }

        void rollWest() {
            int t = top, b = bottom, e = east, w = west;
            top = e;
            bottom = w;
            east = b;
            west = t;
        }

        void rollNorth() {
            int t = top, b = bottom, n = north, s = south;
            top = s;
            bottom = n;
            north = t;
            south = b;
        }

        void rollSouth() {
            int t = top, b = bottom, n = north, s = south;
            top = n;
            bottom = s;
            north = b;
            south = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[] command = new int[K];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        Dice dice = new Dice();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            command[i] = Integer.parseInt(st.nextToken());
        }

        for (int i : command) {
            int nextX = x + dx[i - 1];
            int nextY = y + dy[i - 1];

            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;

            x = nextX;
            y = nextY;

            if (i == 1) dice.rollEast();
            else if (i == 2) dice.rollWest();
            else if (i == 3) dice.rollNorth();
            else dice.rollSouth();

            if (map[x][y] == 0) {
                map[x][y] = dice.bottom;
            } else {
                dice.bottom = map[x][y];
                map[x][y] = 0;
            }

            sb.append(dice.top).append("\n");
        }

        System.out.print(sb);
    }
}