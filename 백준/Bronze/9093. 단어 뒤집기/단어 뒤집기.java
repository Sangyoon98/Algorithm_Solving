import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String[] word = br.readLine().split(" ");

            for (String w : word) {
                StringBuilder sb = new StringBuilder(w).reverse();
                answer.append(sb).append(" ");
            }

            answer.append("\n");
        }

        System.out.print(answer);
    }
}