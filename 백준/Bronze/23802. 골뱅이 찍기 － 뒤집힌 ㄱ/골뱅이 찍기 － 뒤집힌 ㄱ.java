import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            sb.append("@".repeat(5 * N));
            sb.append("\n");
        }

        for (int i = 0; i < 4 * N; i++) {
            sb.append("@".repeat(N));
            sb.append("\n");
        }

        System.out.print(sb);
    }
}