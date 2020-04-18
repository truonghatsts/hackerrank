package org.truonghatsts;

import java.util.*;

class JavaStack {

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        List<Character> open = Arrays.asList('{', '[', '(');
        List<Character> close = Arrays.asList('}', ']', ')');
        while (sc.hasNext()) {
            String input = sc.next();
            Stack<Character> stack = new Stack<>();
            for (char c : input.toCharArray()) {
                if (open.contains(c)) {
                    stack.push(c);
                }
                if (close.contains(c)) {
                    if (!stack.isEmpty()) {
                        Character opening = stack.peek();
                        if (close.get(open.indexOf(opening)).equals(c)) {
                            stack.pop();
                        }
                    } else {
                        stack.push('E');
                        break;
                    }
                }
            }
            System.out.println(stack.isEmpty());
        }
    }
}



