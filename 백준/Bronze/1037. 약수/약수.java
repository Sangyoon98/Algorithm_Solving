import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int d = Integer.parseInt(st.nextToken());
            min = Math.min(min, d);
            max = Math.max(max, d);
        }

        System.out.println(min * max);
    }
}