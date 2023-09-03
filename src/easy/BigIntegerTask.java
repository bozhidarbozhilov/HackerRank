package easy;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerTask {
    public static void solution(){
        Scanner sc = new Scanner(System.in);

        BigInteger firstNumber = new BigInteger(sc.nextLine());
        BigInteger secondNumber = new BigInteger(sc.nextLine());
        System.out.println(firstNumber.add(secondNumber));
        System.out.println(firstNumber.multiply(secondNumber));




    }
}
