import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        st.nextToken();

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            answer.append(sb.append(br.readLine()).reverse()).append("\n");
        }

        System.out.print(answer);
    }
}