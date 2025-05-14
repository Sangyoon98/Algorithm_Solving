import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println((int) (N * 0.78) + " " + (int) (N * 0.8 + (N * 0.2 * 0.78)));
    }
}