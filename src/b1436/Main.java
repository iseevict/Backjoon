package b1436;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int count = 0;

    static void run() {
        for(int i = 666; i < Integer.MAX_VALUE; i++) {
            if (check(i)) count++;
            if (count == N) {
                System.out.println(i);
                return;
            }
        }
    }

    static boolean check(int num) {
        int count2 = 0;
        String strNum = Integer.toString(num);
        boolean btn = true;
        for (int i = 0; i < strNum.length(); i++) {
            int temp = strNum.charAt(i) - '0';
            if (temp == 6 && btn) {
                count2++;
                btn = true;
            }
            else if (temp == 6 && !btn){
                count2++;
                btn = true;
            }
            else {
                count2 = 0;
                btn = false;
            }
            if (count2 >= 3) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buf.readLine());
        run();
    }
}
