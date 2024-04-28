package b10951;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(scan.hasNext()) {
            int A = scan.nextInt();
            int B = scan.nextInt();
            System.out.println(A + B);
        }
    }
}
