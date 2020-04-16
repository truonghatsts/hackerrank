package org.truonghatsts;

import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        return move(game, leap, 0, new HashSet<Integer>());
    }

    private static boolean move(int[] game, int leap, int position, Set<Integer> lastMoves) {
        if (position > game.length - 1) {
            return true;
        } else if (!lastMoves.contains(position) && position >= 0 && game[position] == 0) {
            Set<Integer> updatedMoves = new HashSet<>(lastMoves);
            updatedMoves.add(position);
            boolean result = move(game, leap, position - 1, updatedMoves);
            if (!result) {
                result = move(game, leap, position + 1, updatedMoves);
            }
            if (!result) {
                result = move(game, leap, position + leap, updatedMoves);
            }
            return result;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}