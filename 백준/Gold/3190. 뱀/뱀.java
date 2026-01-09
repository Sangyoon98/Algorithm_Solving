import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];
        boolean[][] snake = new boolean[N + 1][N + 1];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            map[X][Y] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        Map<Integer, Character> command = new HashMap<>();

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            command.put(X, C);
        }

        Deque<int[]> deque = new LinkedList<>();
        deque.addFirst(new int[] { 1, 1 });
        snake[1][1] = true;
        int direction = 0;
        int time = 0;

        while (true) {
            time++;

            int[] head = deque.peekFirst();
            int nextX = head[0] + dx[direction];
            int nextY = head[1] + dy[direction];

            if (nextX < 1 || nextY < 1 || nextX > N || nextY > N) break;
            if (snake[nextX][nextY]) break;

            deque.addFirst(new int[] { nextX, nextY });
            snake[nextX][nextY] = true;

            if (map[nextX][nextY] == 1) {
                map[nextX][nextY] = 0;
            } else {
                int[] tail = deque.removeLast();
                snake[tail[0]][tail[1]] = false;
            }

            if (command.containsKey(time)) {
                char c = command.get(time);
                if (c == 'D') direction = (direction + 1) % 4;
                else direction = (direction + 3) % 4;
            }
        }

        System.out.println(time);
    }
}