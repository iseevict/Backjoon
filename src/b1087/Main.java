package b1087;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buf.readLine());
        int ans = 1;
        for (int i = 1; i <= N; i++) {
            ans *= i;
        }
        System.out.println(ans);
    }
}
