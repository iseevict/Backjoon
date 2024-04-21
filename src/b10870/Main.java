package b10870;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());

        System.out.println(fibo(n));
    }

    static int fibo(int num) {
        if (num == 0) {
            return 0;
        }
        else if (num == 1) {
            return 1;
        }
        else {
            return fibo(num - 2) + fibo(num - 1);
        }
    }
}
