package easy.anagrams;

import java.util.Scanner;

public class Solution {

    private static boolean isAnagram(String a, String b) {
        // Complete the function
        boolean isAnagram = true;

        a = a.toLowerCase();
        b = b.toLowerCase();

        char[] balance = new char[26];

        if(a.length() == b.length()) {
            for(int i = 0; i < a.length(); i++){
                balance[a.charAt(i) - 'a']++;
                balance[b.charAt(i)-'a']--;
            }
            for (char aBalance : balance) {
                if (aBalance != 0) {
                    isAnagram = false;
                    break;
                }
            }
        }else {
            isAnagram = false;
        }



        return isAnagram;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}


