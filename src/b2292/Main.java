package b2292;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(buf.readLine());
        int num = 1;
        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            num = num + 6 * i;
            if (N <= num) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
