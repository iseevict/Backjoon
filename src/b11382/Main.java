package b11382;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static Long A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        System.out.println(A + B + C);
    }
}
