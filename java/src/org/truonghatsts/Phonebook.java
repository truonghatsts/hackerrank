package org.truonghatsts;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {

    public static void main(String[] argh) {

        Map<String, Integer> phonebook = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            in.nextLine();
            phonebook.put(name, phone);
        }
        while (in.hasNext()) {
            String query = in.nextLine();
            Integer phone = phonebook.get(query);
            if (phone != null) {
                System.out.println(query + "=" + phone);
            } else {
                System.out.println("Not found");
            }
        }
    }
}



