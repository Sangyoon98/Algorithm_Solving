import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();

        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            int length = 1;
            int r = 1 % n;

            while (r != 0) {
                r = (r * 10 + 1) % n;
                length++;
            }

            sb.append(length).append("\n");
        }

        System.out.println(sb);
    }
}