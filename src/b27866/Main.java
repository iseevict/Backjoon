package b27866;

import java.io.*;
import java.util.*;

public class Main {
    static String[] s;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        s = buf.readLine().split("");
        n = Integer.parseInt(buf.readLine());
        System.out.println(s[n - 1]);
    }
}
