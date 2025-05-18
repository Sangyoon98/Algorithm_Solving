import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id = ":" + sc.next() + ":";
        String fan = ":fan:";
        StringBuilder sb = new StringBuilder();
        sb.append(fan.repeat(3)).append("\n");
        sb.append(fan).append(id).append(fan).append("\n");
        sb.append(fan.repeat(3)).append("\n");
        System.out.print(sb);
    }
}