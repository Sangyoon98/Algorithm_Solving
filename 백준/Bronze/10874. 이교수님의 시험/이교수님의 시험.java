import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean isAll = true;

            for (int j = 1; j <= 10; j++) {
                int num = Integer.parseInt(st.nextToken());
                int answer = ((j - 1) % 5) + 1;
                if (num != answer) {
                    isAll = false;
                    break;
                }
            }

            if (isAll) sb.append(i).append("\n");
        }

        System.out.print(sb);
    }
}