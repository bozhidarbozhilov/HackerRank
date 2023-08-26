package easy.stdinout;

import java.util.*;

class Solution{
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        int[][] input = new int[t][3];
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            input[i][0] = a;
            input[i][1] = b;
            input[i][2] = n;

        }
        in.close();
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < input[i][2]; j++) {
                input[i][0] += (int) Math.pow(2, j)*input[i][1];
                System.out.printf("%d ", input[i][0]);
            }
            System.out.printf("%n");
        }

    }
}