import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] seats = br.readLine().toCharArray();
        int L = 0;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 'L') {
                L++;
                i++;
            }
        }

        int answer = Math.min(N, N + 1 - L);
        System.out.println(answer);
    }
}