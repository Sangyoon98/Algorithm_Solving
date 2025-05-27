import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int burgerMin = Integer.MAX_VALUE;
        int drinkMin = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) burgerMin = Math.min(burgerMin, Integer.parseInt(br.readLine()));
        for (int i = 0; i < 2; i++) drinkMin = Math.min(drinkMin, Integer.parseInt(br.readLine()));

        System.out.print(burgerMin + drinkMin - 50);
    }
}