import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            int G = Integer.parseInt(st.nextToken());
            int score = (G * 100) / N;

            if (0 <= score && score <= 4) sb.append(1).append(" ");
            else if (4 < score && score <= 11) sb.append(2).append(" ");
            else if (11 < score && score <= 23) sb.append(3).append(" ");
            else if (23 < score && score <= 40) sb.append(4).append(" ");
            else if (40 < score && score <= 60) sb.append(5).append(" ");
            else if (60 < score && score <= 77) sb.append(6).append(" ");
            else if (77 < score && score <= 89) sb.append(7).append(" ");
            else if (89 < score && score <= 96) sb.append(8).append(" ");
            else if (96 < score && score <= 100) sb.append(9).append(" ");
        }

        System.out.print(sb);
    }
}