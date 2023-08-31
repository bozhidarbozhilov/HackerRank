package medium.stackparantheses;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            String str = sc.nextLine();
            boolean isBalanced = balanceCheck(str);
            System.out.println(isBalanced);
        }
        sc.close();
    }

    private static boolean balanceCheck(String str) {
        Deque<String> stack = new ArrayDeque<>();
        String[] tokens = str.split("");
        if(tokens.length % 2 != 0){
            return false;
        }
        for (int i = 0; i < tokens.length; i++) {

            if(!stack.isEmpty()){
                if(tokens[i].equals("]")&&stack.peek().equals("[")){
                    stack.pop();
                    continue;
                }else if(tokens[i].equals(")")&&stack.peek().equals("(")){
                    stack.pop();
                    continue;
                }else if(tokens[i].equals("}")&&stack.peek().equals("{")){
                    stack.pop();
                    continue;
                }

            }
            stack.push(tokens[i]);
        }
        return stack.isEmpty();
    }
}
