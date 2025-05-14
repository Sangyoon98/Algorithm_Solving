import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) arr[i] = br.readLine();

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                if (sum(o1) == sum(o2)) return o1.compareTo(o2);
                return Integer.compare(sum(o1), sum(o2));
            }
            return Integer.compare(o1.length(), o2.length());
        });

        for (String s : arr) System.out.println(s);
    }

    public static int sum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) sum += c - '0';
        }
        return sum;
    }
}