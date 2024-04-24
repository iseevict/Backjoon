package b2231;

import java.io.*;
import java.util.*;

public class Main {
    static int N;

    static void find(int Len) {
        for(int i = 1; i <= N; i++) {
            int tempLen = (int)(Math.log10(i) + 1);
            if (tempLen < Len - 1) continue;
            int sum = i + numSum(i, tempLen);
            if (N == sum) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("0");
    }

    static int numSum(int n, int len) {
        int sum = 0;
        for (int i = 1; i <= len; i++) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buf.readLine());
        int length = (int)(Math.log10(N) + 1);
        find(length);
    }
}
