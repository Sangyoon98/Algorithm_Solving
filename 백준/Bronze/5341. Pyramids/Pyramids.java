import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            sb.append(factorial(n)).append("\n");
        }

        System.out.print(sb);
    }

    static int factorial(int n) {
        if (n == 1) return 1;
        return n + factorial(n - 1);
    }
}