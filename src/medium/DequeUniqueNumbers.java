package medium;

import java.rmi.activation.ActivationGroup_Stub;
import java.util.*;
import java.util.stream.Collectors;

public class DequeUniqueNumbers {
    public static void solution(){

        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();

        int n = in.nextInt();
        int m = in.nextInt();
        int max=0;
        int i = 0;
        while(i < n) {
            int num = in.nextInt();
            deque.add(num);
            if(deque.size() == m){
                Set<Integer> d = new HashSet<>(deque);
                if(d.size() > max){
                    max = d.size();
                }
                deque.remove();
            }
            i++;
        }
        System.out.println(max);
        in.close();
    }



}
