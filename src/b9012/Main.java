package b9012;

import java.io.*;
import java.util.*;

public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(buf.readLine());
        do {
            int count = 0;
            char[] arr = buf.readLine().toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '(') count++;
                else count--;
                if (count < 0) {
                    break;
                }
            }
            if (count == 0) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        } while(--T > 0);
    }
}
