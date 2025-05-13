import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (M <= s.length()) map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> words = new ArrayList<>(map.keySet());
        words.sort((o1, o2) -> {
            if ((int) map.get(o1) != map.get(o2)) return Integer.compare(map.get(o2), map.get(o1));
            if (o1.length() != o2.length()) return o2.length() - o1.length();
            return o1.compareTo(o2);
        });

        for (String s : words) bw.write(s + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}