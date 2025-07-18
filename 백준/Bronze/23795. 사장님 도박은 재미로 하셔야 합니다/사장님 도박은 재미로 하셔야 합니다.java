import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long sum = 0;

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == -1) break;
            sum += N;
        }

        System.out.print(sum);
    }
}