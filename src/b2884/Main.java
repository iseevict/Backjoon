package b2884;

import java.io.*;
import java.util.*;

public class Main {
    static int H, M;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        H = scan.nextInt();
        M = scan.nextInt();
        StringBuilder sb = new StringBuilder();

        int temp = M - 45;
        if (temp < 0) {
            H--;
            if (H == -1) {
                H = 23;
            }
            temp += 60;
            sb.append(H).append(" ").append(temp);
        }
        else {
            sb.append(H).append(" ").append(temp);
        }
        System.out.println(sb);
    }
}
