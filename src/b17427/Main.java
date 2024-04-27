package b17427;

import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buf.readLine());
        long ans = 0;
        for(int i = 1; i <= N; i++) {
            ans = ans + (i * (N / i));
        }
        System.out.println(ans);
    }
}
