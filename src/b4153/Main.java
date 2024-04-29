package b4153;

import java.io.*;
import java.util.*;

public class Main {
    static int A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(buf.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (A == 0 && B == 0 && C == 0) break;
            else {
                int max = Math.max(A, B);
                max = Math.max(max, C);
                if (max == A) {
                    A = (int)Math.pow(A, 2);
                    B = (int)Math.pow(B, 2);
                    C = (int)Math.pow(C, 2);
                    if (A == C + B) {
                        sb.append("right\n");
                    }
                    else {
                        sb.append("wrong\n");
                    }
                }
                else if (max == B) {
                    A = (int)Math.pow(A, 2);
                    B = (int)Math.pow(B, 2);
                    C = (int)Math.pow(C, 2);
                    if (B == A + C) {
                        sb.append("right\n");
                    }
                    else {
                        sb.append("wrong\n");
                    }
                }
                else {
                    A = (int)Math.pow(A, 2);
                    B = (int)Math.pow(B, 2);
                    C = (int)Math.pow(C, 2);
                    if (C == A + B) {
                        sb.append("right\n");
                    }
                    else {
                        sb.append("wrong\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
