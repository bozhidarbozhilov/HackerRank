package easy.staticinitializerblock;

import java.util.Scanner;

public class StaticInitializerBlock {

    private static int B;
    private static int H;
    private static Boolean flag;


    static {
        Scanner scanner = new Scanner(System.in);
        B = Integer.parseInt(scanner.nextLine());
        H = Integer.parseInt(scanner.nextLine());
        flag =false;
        if(B > 0 && H > 0){
            flag = true;
        }else {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }
    public static void main(String[] args){

        if(flag){
            int area=B*H;
            System.out.print(area);
        }
    }
}

