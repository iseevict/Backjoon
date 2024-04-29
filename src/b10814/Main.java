package b10814;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(buf.readLine());
        Map<Integer, List<String>> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(buf.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            if(map.containsKey(age)) {
                map.get(age).add(name);
            }
            else {
                List<String> nameList = new ArrayList<>();
                nameList.add(name);
                map.put(age, nameList);
            }
        }
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            int age = entry.getKey();
            List<String> nameList = entry.getValue();

            for (String name : nameList) {
                sb.append(age + " " + name + "\n");
            }
        }
        System.out.println(sb);
    }
}
