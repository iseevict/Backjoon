package b6064;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int M, N, x, y, T;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(buf.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(buf.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            BigInteger num1 = BigInteger.valueOf(M);
            BigInteger num2 = BigInteger.valueOf(N);
            int gcd = num1.gcd(num2).intValue(); // 최대 공약수
            int lcm = M * N / gcd; // 최소 공배수
            int min = Math.min(M, N);
            boolean check = false;
            if (M == x && N == y) {
                sb.append(lcm + "\n");
                continue;
            }
            if (min == M) {
                int count = 0;
                while (min * count <= lcm) {
                    int m = min * count + x;
                    if (m % N == y || (m % N == 0 && N == y)) {
                        sb.append(m + "\n");
                        check = true;
                        break;
                    }
                    count++;
                }
                if (!check) {
                    sb.append("-1\n");
                }
            }
            else if (min == N) {
                int count = 0;
                while (min * count <= lcm) {
                    int m = min * count + y;
                    if (m % M == x || (m % M == 0 && M == x)) {
                        sb.append(m + "\n");
                        check = true;
                        break;
                    }
                    count++;
                }
                if (!check) {
                    sb.append("-1\n");
                }
            }
        }
        System.out.println(sb);
    }
}


