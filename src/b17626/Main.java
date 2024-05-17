package b17626;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] num = new int[500001];

    static int run(int n) {
        int temp = (int)Math.sqrt(n);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= temp; i++) {
            int tempR = num[n - (int)Math.pow(i, 2)];
            if (result > tempR) result = tempR;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(buf.readLine());
        num[1] = 1; num[2] = 2; num[3] = 3; num[4] = 1; num[5] = 2; num[6] = 3; num[7] = 4; num[8] = 2; num[9] = 1;
        for (int i = 10; i <= 50000; i++) {
            num[i] = run(i) + 1;
        }
        System.out.println(num[N]);
    }
}


