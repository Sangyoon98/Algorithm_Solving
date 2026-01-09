import java.io.*;
import java.util.*;

public class Main {
    static int w, h, answer;
    static char[][] map;
    static int[][] fire, people;
    static Deque<int[]> fireDeque, peopleDeque;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            answer = -1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            fire = new int[h][w];
            people = new int[h][w];
            fireDeque = new LinkedList<>();
            peopleDeque = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                Arrays.fill(fire[i], Integer.MAX_VALUE);
                Arrays.fill(people[i], -1);
            }

            for (int i = 0; i < h; i++) {
                char[] line =  br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    map[i][j] = line[j];
                    if (map[i][j] == '*') {
                        fire[i][j] = 0;
                        fireDeque.add(new int[] { i, j });
                    } else if (map[i][j] == '@') {
                        people[i][j] = 0;
                        peopleDeque.add(new int[] { i, j });
                    }
                }
            }

            fireBfs();
            peopleBfs();

            if (answer == -1) sb.append("IMPOSSIBLE").append("\n");
            else sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }

    static void fireBfs() {
        while (!fireDeque.isEmpty()) {
            int[] current = fireDeque.poll();
            int time = fire[current[0]][current[1]];

            for (int i = 0; i < 4; i++) {
                int nextX = current[0] + dx[i];
                int nextY = current[1] + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= h || nextY >= w) continue;
                if (map[nextX][nextY] == '#') continue;
                if (fire[nextX][nextY] <= time + 1) continue;

                fire[nextX][nextY] = time + 1;
                fireDeque.add(new int[] {nextX, nextY});
            }
        }
    }

    static void peopleBfs() {
        while (!peopleDeque.isEmpty()) {
            int[] current = peopleDeque.poll();
            int time = people[current[0]][current[1]];

            for (int i = 0; i < 4; i++) {
                int nextX = current[0] + dx[i];
                int nextY = current[1] + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= h || nextY >= w) {
                    answer = time + 1;
                    return;
                }
                if (map[nextX][nextY] == '#') continue;
                if (people[nextX][nextY] != -1) continue;
                if (fire[nextX][nextY] <= time + 1) continue;

                people[nextX][nextY] = time + 1;
                peopleDeque.add(new int[] {nextX, nextY});
            }
        }
    }
}