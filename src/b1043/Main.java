package b1043;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(buf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boolean[] visit = new boolean[M];
        boolean[] check = new boolean[N + 1];
        List<List<Integer>> party = new ArrayList<>();
        st = new StringTokenizer(buf.readLine());
        int knowNum = Integer.parseInt(st.nextToken());
        Queue<Integer> know = new LinkedList<>();
        for (int i = 0; i < knowNum; i++) {
            int temp = Integer.parseInt(st.nextToken());
            know.add(temp);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(buf.readLine());
            int totalNum = Integer.parseInt(st.nextToken());
            List<Integer> nL = new ArrayList<>();
            for (int j = 0; j < totalNum; j++) {
                int num = Integer.parseInt(st.nextToken());
                nL.add(num);
            }
            party.add(nL);
        }
        if (knowNum == 0) {
            System.out.println(M);
        }
        else {
            int ans = M;
            while (!know.isEmpty()) {
                int tempN = know.poll();

                if (!check[tempN]) check[tempN] = true;
                else continue;

                for (int i = 0; i < M; i++) {
                    List<Integer> tempList = party.get(i);
                    if (!visit[i]) {
                        for (int j : tempList) {
                            if (j == tempN) {
                                visit[i] = true;
                                for (int k : tempList) {
                                    know.add(k);
                                }
                                ans--;
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}

