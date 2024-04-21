package b13235;

import java.io.*;
import java.util.*;

public class Main {

    static char[] arr;

    static void SetValue(String str) {
        arr = str.toCharArray();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str = buf.readLine();
        SetValue(str);

        boolean ans = check(arr.length, arr.length - 1);
        System.out.print(ans);
    }

    static boolean check(int length, int index) {
        if(index < length / 2) {
            return true;
        }
        if (arr[index] == arr[length - index - 1]) {
            return check(length, index - 1);
        }
        else {
            return false;
        }
    }
}
