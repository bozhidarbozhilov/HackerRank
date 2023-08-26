package easy.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayListProblems {
    public static boolean canWin(int leap, int[] game) {
        int current_index = 0;
        int isVisited = 0;
        while(isVisited<game.length) {
            if(current_index+leap < game.length && game[current_index+leap]==0){
                current_index+=leap;
                isVisited++;
            }
            if(current_index-1>0 && game[current_index-1]==0){
                current_index--;
                isVisited++;
            }else if(current_index+1<game.length && game[current_index+1]==0){
                current_index++;
                isVisited++;
            }

            if(current_index==game.length-1 || current_index+leap>=game.length){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //*******ArrayList********
//        int numOfLists = Integer.parseInt(sc.nextLine());
//        List<int[]> lists = new ArrayList<>();
//        for (int i = 0; i < numOfLists; i++) {
//            String[] currentInput = sc.nextLine().split(" ");
//            int[] currentArray = new int[Integer.parseInt(currentInput[0])];
//
//            for (int j = 1; j < currentInput.length; j++) {
//                currentArray[j-1]=Integer.parseInt(currentInput[j]);
//            }
//            lists.add(currentArray);
//        }
//
//        int numOfQueries = Integer.parseInt(sc.nextLine());
//        for (int i = 0; i < numOfQueries; i++) {
//            int[] search = Arrays.stream(sc.nextLine().split(" "))
//                    .mapToInt(Integer::parseInt).toArray();
//            try {
//                int list = search[0] - 1;
//                int index = search[1] - 1;
//                int[] current = lists.get(list);
//                System.out.println(current[index]);
//            } catch (Exception e) {
//                System.out.println("ERROR!");
//            }
//        }
        //********* 1D Array Part 2 *********
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();

    }
}
