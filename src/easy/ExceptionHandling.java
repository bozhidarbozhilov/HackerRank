package easy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {
    public static void solution(){
        Scanner sc = new Scanner(System.in);
        try {
            int firstNum = sc.nextInt();
            int secondNum = sc.nextInt();
            int result = firstNum / secondNum;
            System.out.println(result);
        }catch (InputMismatchException inex){
            System.out.println("java.util.InputMismatchException");
        } catch(Exception ex){
            System.out.println(ex);
        }
    }

}
