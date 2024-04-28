package b10250;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T;
        T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            int H = scan.nextInt();
            int W = scan.nextInt();
            int N = scan.nextInt();
            if (N % H == 0) {
                sb.append(H);
            }
            else {
                sb.append(N % H);
            }
            double door = Math.ceil((double)N / (double)H);
            if (door < 10) {
                sb.append("0");
            }
            sb.append((int)door + "\n");
        }
        System.out.print(sb);
    }
}
