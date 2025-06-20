import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line.equals("# 0 0")) break;
            StringTokenizer st = new StringTokenizer(line);
            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            sb.append(name)
                    .append(" ")
                    .append((age > 17 || weight >= 80) ? "Senior" : "Junior")
                    .append("\n");
        }

        System.out.print(sb);
    }
}