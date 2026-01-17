import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        if (S == G) {
            System.out.println(0);
            return;
        }

        int[] distance = new int[F + 1];
        boolean[] visited = new boolean[F + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        visited[S] = true;
        distance[S] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int nextUp = current + U;
            int nextDown = current - D;

            if (U > 0 && nextUp <= F && !visited[nextUp]) {
                visited[nextUp] = true;
                distance[nextUp] = distance[current] + 1;
                if (nextUp == G) {
                    System.out.println(distance[nextUp]);
                    return;
                }
                queue.add(nextUp);
            }

            if (D > 0 && nextDown >= 1 && !visited[nextDown]) {
                visited[nextDown] = true;
                distance[nextDown] = distance[current] + 1;
                if (nextDown == G) {
                    System.out.println(distance[nextDown]);
                    return;
                }
                queue.add(nextDown);
            }
        }

        System.out.println("use the stairs");
    }
}