import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());

        if (sum < minus || (sum + minus) % 2 != 0 || ((sum - minus) % 2 != 0)) {
            System.out.println(-1);
            return;
        }

        int x = ((sum + minus) / 2);
        int y = ((sum - minus) / 2);
        System.out.print(x + " " + y);
    }
}