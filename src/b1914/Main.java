package b1914;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buf.readLine());
        BigInteger ans = new BigInteger("1");
        for (int i = 0; i < N; i++) {
            ans = ans.multiply(new BigInteger("2"));
        }
        ans = ans.subtract(new BigInteger("1"));
        System.out.println(ans);

        if (N <= 20) {
            hanoi(N, 1, 2, 3);
        }
    }

    static void hanoi(int n, int start, int mid, int end) {
        if (n == 1) {
            System.out.println(start + " " + end);
            return;
        }

        hanoi(n - 1, start, end, mid);
        System.out.println(start + " " + end);
        hanoi(n - 1, mid, start, end);
        return;
    }
}
