import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());
        
        System.out.print((S <= F) ? "high speed rail" : "flight");
    }
}