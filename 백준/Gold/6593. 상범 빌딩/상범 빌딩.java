import java.io.*;
import java.util.*;

public class Main {
    static int[] dl = {1, -1, 0, 0, 0, 0};
    static int[] dr = {0, 0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, 0, -1, 1};

    static class Node {
        int L, R, C;

        public Node(int L, int R, int C) {
            this.L = L;
            this.R = R;
            this.C = C;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            char[][][] map = new char[L][R][C];
            Node start = null;
            Node end = null;

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String line = br.readLine();
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = line.charAt(k);
                        if (map[i][j][k] == 'S') start = new Node(i, j, k);
                        else if (map[i][j][k] == 'E') end = new Node(i, j, k);
                    }
                }
                br.readLine();
            }

            int answer = bfs(map, L, R, C, start, end);
            if (answer == -1) sb.append("Trapped!").append("\n");
            else sb.append("Escaped in ").append(answer).append(" minute(s).").append("\n");
        }

        System.out.print(sb);
    }

    static int bfs(char[][][] map, int L, int R, int C, Node start, Node end) {
        int[][][] distance = new int[L][R][C];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    distance[i][j][k] = -1;
                }
            }
        }

        Deque<Node> queue = new LinkedList<>();
        queue.add(start);
        distance[start.L][start.R][start.C] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.L == end.L && current.R == end.R && current.C == end.C) {
                return distance[current.L][current.R][current.C];
            }

            for (int i = 0; i < 6; i++) {
                int nextL = current.L + dl[i];
                int nextR = current.R + dr[i];
                int nextC = current.C + dc[i];

                if (nextL < 0 || nextL >= L || nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) continue;
                if (map[nextL][nextR][nextC] == '#') continue;
                if (distance[nextL][nextR][nextC] != -1) continue;

                distance[nextL][nextR][nextC] = distance[current.L][current.R][current.C] + 1;
                queue.add(new Node(nextL, nextR, nextC));
            }
        }

        return -1;
    }
}