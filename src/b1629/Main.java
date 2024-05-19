package b1629;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static long run(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }
        else {
            long half = run(a, b / 2, c);

            if (b % 2 == 1) {
                return (half * half % c) * a % c;
            }

            return half * half % c;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(buf.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(run(A, B, C));
    }
}

