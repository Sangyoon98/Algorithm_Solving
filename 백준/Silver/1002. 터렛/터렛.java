import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int dx = x1 - x2;
            int dy = y1 - y2;
            int d2 = dx * dx + dy * dy;
            int sum = r1 + r2;
            int diff = Math.abs(r1 - r2);
            int sum2 = sum * sum;
            int diff2 = diff * diff;
            int result;

            if (x1 == x2 && y1 == y2 && r1 == r2) result = -1;
            else if (d2 > sum2) result = 0;
            else if (d2 < diff2) result = 0;
            else if (d2 == sum2 || d2 == diff2) result = 1;
            else result = 2;

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}