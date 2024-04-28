package b11720;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(buf.readLine());
        int ans = 0;
        String[] s = buf.readLine().split("");
        for(int i = 0; i < s.length; i++) {
            ans = ans + Integer.parseInt(s[i]);
        }
        System.out.println(ans);
    }
}
