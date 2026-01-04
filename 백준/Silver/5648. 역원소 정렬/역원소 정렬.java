import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Long> list = new ArrayList<>();

        while (st.hasMoreElements()) {
            list.add(reverse(st.nextToken()));
        }

        while (list.size() < n) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreElements() && list.size() < n) {
                list.add(reverse(st.nextToken()));
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (long i : list) sb.append(i).append("\n");
        System.out.print(sb);
    }

    public static long reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return Long.parseLong(sb.reverse().toString());
    }
}