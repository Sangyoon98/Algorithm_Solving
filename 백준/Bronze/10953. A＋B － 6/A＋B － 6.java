import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] line = br.readLine().split(",");
            sb.append(Integer.parseInt(line[0]) + Integer.parseInt(line[1])).append("\n");
        }

        System.out.println(sb);
    }
}