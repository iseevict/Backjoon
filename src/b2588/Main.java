package b2588;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(buf.readLine());
        String B = buf.readLine();
        int Bi = Integer.parseInt(B);
        String[] Barr = B.split("");

        for (int i = Barr.length - 1; i >= 0; i--) {
            int temp = Integer.parseInt(Barr[i]);
            System.out.println(A * temp);
        }

        System.out.println(A * Bi);
    }
}
