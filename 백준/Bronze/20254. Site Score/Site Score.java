import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.print(Integer.parseInt(st.nextToken()) * 56 + Integer.parseInt(st.nextToken()) * 24 + Integer.parseInt(st.nextToken()) * 14 + Integer.parseInt(st.nextToken()) * 6);
    }
}