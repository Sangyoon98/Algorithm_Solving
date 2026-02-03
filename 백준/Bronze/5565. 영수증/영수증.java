import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.parseInt(br.readLine());
        for (int i = 0; i < 9; i++) {
            sum -= Integer.parseInt(br.readLine());
        }
        System.out.println(sum);
    }
}