package b2753;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(buf.readLine());

        if (year % 4 == 0) {
            if (year % 400 == 0) {
                System.out.println("1");
            }
            else if (year % 100 == 0) {
                System.out.println("0");
            }
            else {
                System.out.println("1");
            }
        }
        else {
            System.out.println("0");
        }
    }
}
