import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] cup = {1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");

        for (String s : arr) {
            if (s.equals("A")) swap(0, 1);
            if (s.equals("B")) swap(1, 2);
            if (s.equals("C")) swap(0, 2);
        }

        for (int i = 0; i < cup.length; i++) {
            if (cup[i] == 1) System.out.print(i + 1);
        }
    }

    static void swap(int a, int b) {
        int temp = cup[a];
        cup[a] = cup[b];
        cup[b] = temp;
    }
}