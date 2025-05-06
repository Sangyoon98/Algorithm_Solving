import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            HashSet<Integer> map1 = new HashSet<>();

            for (int i = 0; i < N; i++) map1.add(Integer.parseInt(st.nextToken()));

            ArrayList<Integer> arr = new ArrayList<>(map1);
            Collections.sort(arr);

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] map2 = new int[M];

            for (int i = 0; i < M; i++) map2[i] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < M; i++) sb.append((Collections.binarySearch(arr, map2[i]) >= 0) ? 1 : 0).append("\n");
        }
        System.out.print(sb);
    }
}