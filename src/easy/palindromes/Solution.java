package easy.palindromes;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        StringBuilder reversed = new StringBuilder();

        for(int i = A.length()-1; i>=0;i--){
            reversed.append(A.charAt(i));
        }
        if(A.equals(reversed.toString())){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}