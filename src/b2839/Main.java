package b2839;

import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buf.readLine());
        int L1 = N / 3;
        int L2 = N / 5;
        for (int i = 0; i <= L1; i++) {
            for (int j = 0; j <= L2; j++) {
                if (3 * i + 5 * j == N) {
                    System.out.println(i + j);
                    return;
                }
            }
        }
        System.out.println("-1");
    }
}
