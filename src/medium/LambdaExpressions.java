package medium;

import java.io.*;
import java.util.*;

class LambdaExpressions{
    interface PerformOperation {
        boolean check(int a);
    }
    static class MyMath {
        public static boolean checker(PerformOperation p, int num) {
            return p.check(num);
        }

        public PerformOperation isOdd(){
            return (x) -> x % 2 != 0;
        }

        public PerformOperation isPrime(){
            return (x) -> {
                if(x==1){
                    return false;
                }
                if(x==2){
                    return true;
                }
                for (int i = 3; i <= Math.sqrt(x); i++) {
                    if(x % i == 0){
                        return false;
                    }
                }
                return true;
            };
        }
        public PerformOperation isPalindrome(){
            return (x)->{
                StringBuilder sb = new StringBuilder();
                int num = x;
                while(num > 0){
                    sb.append(num%10);
                    num/=10;
                }
                int reversed = Integer.parseInt(sb.toString());
                return x == reversed;
            };
        }

        // Write your code here
    }


    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }

}

}

