import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer>[] gear = new ArrayDeque[4];

        for (int i = 0; i < 4; i++) {
            gear[i] = new ArrayDeque<>();
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i].addLast(line.charAt(j) - '0');
            }
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            int[] rotate = new int[4];
            rotate[index] = direction;

            // left check
            for (int j = index; j > 0; j--) {
                if (get(gear[j], 6) != get(gear[j - 1], 2)) rotate[j - 1] = -rotate[j];
                else break;
            }

            // right check
            for (int j = index; j < 3; j++) {
                if (get(gear[j], 2) != get(gear[j + 1], 6)) rotate[j + 1] = -rotate[j];
                else break;
            }

            // rotate
            for (int j = 0; j < 4; j++) {
                if (rotate[j] == 1) gear[j].addFirst(gear[j].pollLast());
                else if (rotate[j] == -1) gear[j].addLast(gear[j].pollFirst());
            }
        }

        int score = 0;
        if (gear[0].peekFirst() == 1) score += 1;
        if (gear[1].peekFirst() == 1) score += 2;
        if (gear[2].peekFirst() == 1) score += 4;
        if (gear[3].peekFirst() == 1) score += 8;

        System.out.println(score);
    }

    static int get(Deque<Integer> deque, int index) {
        int i = 0;
        for (int q : deque) {
            if (i++ == index) return q;
        }
        return -1;
    }
}