import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = (int) ((long) Y * 100 / X);
        int answer = -1;
        int min = 0;
        int max = 1000000000;

        while (min <= max) {
            int mid = (min + max) / 2;
            int result = (int) (((double) (Y + mid) * 100 / (X + mid)));
            if (result != Z) {
                answer = mid;
                max = mid - 1;
            } else min = mid + 1;
        }

        System.out.print(answer);
    }
}