import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "WelcomeToSMUPC";
        int N = Integer.parseInt(br.readLine());
        int index = N % 14;
        if (index <= 0) System.out.print(str.charAt(13));
        else System.out.print(str.charAt(N % 14 - 1));
    }
}