package b15829;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(buf.readLine());
        char[] arr = buf.readLine().toCharArray();
        int len = arr.length;
        BigInteger sum = new BigInteger("0");
        BigInteger mod = new BigInteger("1234567891");
        BigInteger r = new BigInteger("31");
        for (int i = 0; i < len; i++) {
            String s = Integer.toString(arr[i] - 96);
            BigInteger temp = new BigInteger(s);
            BigInteger mul = r.pow(i);
            temp = temp.multiply(mul);
            sum = sum.add(temp);
        }
        sum = sum.mod(mod);
        System.out.println(sum);
    }
}
