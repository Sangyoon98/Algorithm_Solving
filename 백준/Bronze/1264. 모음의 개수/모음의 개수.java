import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line.equals("#")) break;

            char[] word = line.toCharArray();
            int count = 0;

            for (char w : word) {
                if (w == 'a' ||  w == 'e' || w == 'i' || w == 'o' || w == 'u') count++;
                else if (w == 'A' || w == 'E' || w == 'I' || w == 'O' || w == 'U') count++;
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}