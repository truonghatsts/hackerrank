package org.truonghatsts;

import java.util.*;

public class InsertDelete {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scan.nextInt());
        }
        int q = scan.nextInt();
        for (int i = 0; i < q; i++) {
            String query = scan.next();
            if(query.equals("Insert")) {
                int x = scan.nextInt();
                int y = scan.nextInt();
                list.add(x, y);
            }
            if(query.equals("Delete")) {
                int x = scan.nextInt();
                list.remove(x);
            }
        }
        for(Integer i:list) {
            System.out.print(i);
            System.out.print(" ");
        }
        scan.close();
    }
}