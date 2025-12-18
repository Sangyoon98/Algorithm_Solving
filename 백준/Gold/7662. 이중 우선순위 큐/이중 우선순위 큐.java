import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Long, Integer> map = new TreeMap<>();

            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                long n = Integer.parseInt(st.nextToken());

                if (c == 'I') {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;
                    long key;
                    if (n == 1) key = map.lastKey();
                    else key = map.firstKey();

                    int count = map.get(key);
                    if (count == 1) map.remove(key);
                    else map.put(key, count - 1);
                }
            }

            if (map.isEmpty()) sb.append("EMPTY").append("\n");
            else sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
        }

        System.out.println(sb);
    }
}