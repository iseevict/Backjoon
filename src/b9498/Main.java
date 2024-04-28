package b9498;

import java.io.*;
import java.util.*;

public class Main {
    static int score;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        score = Integer.parseInt(buf.readLine());
        if (score >= 90) {
            System.out.println("A");
        }
        else if (score >= 80) {
            System.out.println("B");
        }
        else if (score >= 70) {
            System.out.println("C");
        }
        else if (score >= 60) {
            System.out.println("D");
        }
        else {
            System.out.println("F");
        }
    }
}
