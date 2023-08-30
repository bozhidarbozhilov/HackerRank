package easy.arraylistch32;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> result = new ArrayList<>();
        int length = Integer.parseInt(in.nextLine());
        String line = in.nextLine();
        String[] strList = line.split("\\s");

        for (int i = 0; i < strList.length; i++) {
            result.add(Integer.parseInt(strList[i]));
        }
        int queries = Integer.parseInt(in.nextLine());
        for (int i = 0; i < queries; i++) {
            String command = in.nextLine();
            if(command.equals("Insert")){
                String[] numbers = in.nextLine().split("\\s");
                int index = Integer.parseInt(numbers[0]);
                int value = Integer.parseInt(numbers[1]);
                result.add(index, value);
            }else{
                result.remove(Integer.parseInt(in.nextLine()));
            }
        }
        String resultStr = result.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(resultStr);
    }
}
