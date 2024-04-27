package b4375;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BigInteger N;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            N = scanner.nextBigInteger();
            BigInteger num = new BigInteger("1");
            long ans = 1;
            while(true) {
                if (num.mod(N).compareTo(BigInteger.ZERO) == 0) break;
                else {
                    ans++;
                    num = num.multiply(BigInteger.TEN).add(BigInteger.ONE).mod(N);
                }
            }
            System.out.println(ans);
        }
    }
}
