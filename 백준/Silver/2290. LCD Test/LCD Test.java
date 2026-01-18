import java.io.*;
import java.util.*;

public class Main {
    static int s;
    static boolean[][] segment = new boolean[10][7];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        s = Integer.parseInt(st.nextToken());
        String n = st.nextToken();

        segment[0] = new boolean[]{true, true, true, true, true, true, false};
        segment[1] = new boolean[]{false, true, true, false, false, false, false};
        segment[2] = new boolean[]{true, true, false, true, true, false, true};
        segment[3] = new boolean[]{true, true, true, true, false, false, true};
        segment[4] = new boolean[]{false, true, true, false, false, true, true};
        segment[5] = new boolean[]{true, false, true, true, false, true, true};
        segment[6] = new boolean[]{true, false, true, true, true, true, true};
        segment[7] = new boolean[]{true, true, true, false, false, false, false};
        segment[8] = new boolean[]{true, true, true, true, true, true, true};
        segment[9] = new boolean[]{true, true, true, true, false, true, true};

        for (int i = 0; i < (2 * s + 3); i++) {
            StringBuilder line = new StringBuilder();

            for (int j = 0; j < n.length(); j++) {
                int str = n.charAt(j) - '0';
                line.append(render(str, i));
                if (j != n.length() - 1) line.append(" ");
            }
            sb.append(line).append("\n");
        }

        System.out.println(sb);
    }

    static String render(int str, int i) {
        int width = s + 2;
        StringBuilder sb = new StringBuilder(width);
        boolean a = segment[str][0];
        boolean b = segment[str][1];
        boolean c = segment[str][2];
        boolean d = segment[str][3];
        boolean e = segment[str][4];
        boolean f = segment[str][5];
        boolean g = segment[str][6];

        if (i == 0) {
            sb.append(" ")
                    .append(a ? "-".repeat(s) : " ".repeat(s))
                    .append(" ");
        } else if (i >= 1 && s >= i) {
            sb.append(f ? "|" : " ")
                    .append(" ".repeat(s))
                    .append(b ? "|" : " ");
        } else if (i == s + 1) {
            sb.append(" ")
                    .append(g ? "-".repeat(s) : " ".repeat(s))
                    .append(" ");
        } else if (i >= s + 2 && 2 * s + 1 >= i) {
            sb.append(e ? "|" : " ")
                    .append(" ".repeat(s))
                    .append(c ? "|" : " ");
        } else {
            sb.append(" ")
                    .append(d ? "-".repeat(s) : " ".repeat(s))
                    .append(" ");
        }

        return sb.toString();
    }
}