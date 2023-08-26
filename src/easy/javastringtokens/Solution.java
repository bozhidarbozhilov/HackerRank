package easy.javastringtokens;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine().trim();
        String[] tokens = s.split("[\\s'!,.?_@]+");

        if(tokens.length ==1 && tokens[0].isEmpty()){
            System.out.println("0");
        }else {
            System.out.println(tokens.length);
            for (String token : tokens) {
                System.out.println(token);
            }
        }
        scan.close();
    }
}


