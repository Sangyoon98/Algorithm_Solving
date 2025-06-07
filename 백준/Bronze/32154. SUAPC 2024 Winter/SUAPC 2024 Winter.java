import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        switch (N) {
            case 1:
                System.out.println(11);
                System.out.print("A B C D E F G H J L M");
                break;
            case 2:
            case 3:
                System.out.println(9);
                System.out.print("A C E F G H I L M");
                break;
            case 4:
                System.out.println(9);
                System.out.print("A B C E F G H L M");
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                System.out.println(8);
                System.out.print("A C E F G H L M");
                break;
            case 10:
                System.out.println(8);
                System.out.print("A B C F G H L M");
                break;
        }
    }
}