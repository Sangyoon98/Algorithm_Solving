import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String N = br.readLine();
        long answer = 0;

        for (int i = 0; i < N.length(); i++) {
            answer = (answer * 10 + (N.charAt(i) - '0')) % 20000303;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}