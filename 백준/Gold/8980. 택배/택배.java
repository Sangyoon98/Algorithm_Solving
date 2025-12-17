import java.io.*;
import java.util.*;

public class Main {
    static class Box {
        int from, to, box;
        Box(int f, int t, int b) {
            from = f;
            to = t;
            box = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        List<Box> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int box = Integer.parseInt(st.nextToken());
            list.add(new Box(from, to, box));
        }

        list.sort((a, b) -> Integer.compare(a.to, b.to));
        int[] load = new int[N + 1];
        int answer = 0;

        for (Box box : list) {
            int max = Integer.MAX_VALUE;
            for (int i = box.from; i < box.to; i++) {
                max = Math.min(max, C - load[i]);
            }
            
            int take = Math.min(max, box.box);
            if (take < 0) take = 0;

            for (int i = box.from; i < box.to; i++) {
                load[i] += take;
            }

            answer += take;
        }

        System.out.println(answer);
    }
}