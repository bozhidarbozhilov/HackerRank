
package medium.array1d;
import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.

        return isReachable(0, leap, game);
    }

    private static boolean isReachable(int startIndex, int leap,  int[] game){
        if(startIndex < 0 || game[startIndex] == 1){
            return false;
        }
        if(startIndex == game.length-1 || startIndex + leap > game.length - 1 || startIndex + 1 > game.length -1){
            return true;
        }

        game[startIndex] = 1;

        return isReachable(startIndex+leap,leap, game)||
                isReachable(startIndex + 1, leap, game) ||
                isReachable(startIndex-1, leap, game);
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
            boolean result=canWin(leap, game);
            System.out.println( (result) ? "YES" : "NO" );
        }
        scan.close();
    }
}
