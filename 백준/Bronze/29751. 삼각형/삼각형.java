import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double W = Integer.parseInt(st.nextToken());
        double H = Integer.parseInt(st.nextToken());
        System.out.printf("%.1f", (W * H) / 2);
    }
}