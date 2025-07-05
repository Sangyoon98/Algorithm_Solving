import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals("***")) break;
            StringBuilder s = new StringBuilder();
            s.append(str).reverse();
            sb.append(s).append("\n");
        }

        System.out.print(sb);
    }
}