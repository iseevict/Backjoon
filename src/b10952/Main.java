package b10952;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(scan.hasNext()) {
            int A = scan.nextInt();
            int B = scan.nextInt();
            if (A == 0 && B == 0) {
                break;
            }
            sb.append(A + B).append("\n");
        }
        System.out.println(sb);
    }
}
