import java.io.*;
import java.util.*;

public class Main {
    static int K, W, H;
    static int[][] map;
    static int[] dh = {-1, 1, 0, 0};
    static int[] dw = {0, 0, -1, 1};
    static int[] dhHorse = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dwHorse = {-1, 1, -2, 2, -2, 2, -1, 1};

    static class Node {
        int h, w, k, distance;
        Node(int h, int w, int k, int distance) {
            this.h = h;
            this.w = w;
            this.k = k;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        boolean[][][] visited = new boolean[H][W][K + 1];
        Queue<Node> queue = new LinkedList<>();
        visited[0][0][0] = true;
        queue.add(new Node(0, 0, 0, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.h == H - 1 && current.w == W - 1) return current.distance;

            for (int i = 0; i < 4; i++) {
                int nh = current.h + dh[i];
                int nw = current.w + dw[i];

                if (nh < 0 || nw < 0 || nh >= H || nw >= W) continue;
                if (map[nh][nw] == 1) continue;
                if (visited[nh][nw][current.k]) continue;

                visited[nh][nw][current.k] = true;
                queue.add(new Node(nh, nw, current.k, current.distance + 1));
            }

            if (current.k < K) {
                int nk = current.k + 1;
                for (int i = 0; i < 8; i++) {
                    int nh = current.h + dhHorse[i];
                    int nw = current.w + dwHorse[i];

                    if (nh < 0 || nw < 0 || nh >= H || nw >= W) continue;
                    if (map[nh][nw] == 1) continue;
                    if (visited[nh][nw][nk]) continue;

                    visited[nh][nw][nk] = true;
                    queue.add(new Node(nh, nw, nk, current.distance + 1));
                }
            }
        }

        return -1;
    }
}