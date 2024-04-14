package b1152;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String tempString = buf.readLine();
        if (tempString.equals(" ")) {
            System.out.println("0");
        }
        else {
            String[] arr = tempString.split(" ");
            if (arr[0].equals("") && arr.length == 1) System.out.println("0");
            else if (arr[0].equals("")) {
                System.out.println(arr.length - 1);
            } else {
                System.out.println(arr.length);
            }
        }
    }
}
