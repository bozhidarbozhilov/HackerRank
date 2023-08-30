package easy.mapch33;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lenght = Integer.parseInt(scanner.nextLine());
        Map<String, String> resultMap = new HashMap<>();
        for (int i = 0; i < lenght; i++) {
            String name = scanner.nextLine();
            String number = scanner.nextLine();
            resultMap.put(name, number);
        }

        while(scanner.hasNext()){
            String line = scanner.nextLine();
            if ((resultMap.containsKey(line))) {
                System.out.println(line + "=" + resultMap.get(line));
            } else {
                System.out.println("Not found");
            }
        }
        scanner.close();
    }
}
