package b2609;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    static int run1(int high, int low) { // 최대공약수
        for (int i = low; i >= 1; i--) {
            if (low % i == 0) {
                if (high % i == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    static int run2(int high, int low) { // 최소공배수
        for (int i = high; true; i++) {
            if (i % high == 0) {
                if (i % low == 0) {
                    return i;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int high = Math.max(M, N);
        int low = Math.min(M, N);
        System.out.println(run1(high, low));
        System.out.println(run2(high, low));
    }
}
