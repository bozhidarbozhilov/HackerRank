package easy;

import java.util.BitSet;
import java.util.Scanner;

public class BitSetTask {
    public static void solution() {

        Scanner sc = new Scanner(System.in);

        String[] tokens = sc.nextLine().split("\\s");
        int length = Integer.parseInt(tokens[0]);
        int numOfOperations = Integer.parseInt(tokens[1]);
        BitSet bs1 = new BitSet(length);
        BitSet bs2 = new BitSet(length);
        for (int i = 0; i < length; i++) {
            bs1.set(i, false);
            bs2.set(i, false);
        }

        for (int i = 0; i < numOfOperations; i++) {
            String[] input = sc.nextLine().split("\\s");
            String operation = input[0];
            int firstNum = Integer.parseInt(input[1]);
            int secondNum = Integer.parseInt(input[2]);
            switch (operation) {
                case "AND":
                    if (firstNum == 1) {
                        bs1.and(bs2);
                    } else {
                        bs2.and(bs1);
                    }
                    break;
                case "OR":
                    if (firstNum == 1) {
                        bs1.or(bs2);
                    } else {
                        bs2.or(bs1);
                    }
                    break;
                case "XOR":
                    if (firstNum == 1) {
                        bs1.xor(bs2);
                    } else {
                        bs2.xor(bs1);
                    }
                    break;
                case "FLIP":
                    if (firstNum == 1) {
                        bs1.set(secondNum, !bs1.get(secondNum));
                    } else {
                        bs2.set(secondNum, !bs2.get(secondNum));
                    }
                    break;
                case "SET":
                    if (firstNum == 1) {
                        bs1.set(secondNum, true);
                    } else {
                        bs2.set(secondNum, true);
                    }
                    break;
                default:
                    break;
            }
            System.out.println(bs1.cardinality() + " " + bs2.cardinality());
        }

    }

    private static BitSet convertToBitSet(int num, int length) {
        BitSet result = new BitSet(length);

        for (int i = 0; i < length; i++) {
            boolean isSetBit = (num & (1 << i)) != 0;
            result.set(i, isSetBit);
        }
        return result;
    }
}

