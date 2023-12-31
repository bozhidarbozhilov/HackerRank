package medium;

import java.rmi.activation.ActivationGroup_Stub;
import java.util.*;
import java.util.stream.Collectors;

public class DequeUniqueNumbers {
    public static void solution(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Deque<Integer> deque = new ArrayDeque<>(n);
        int max=0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            if(i >= m-1){
                Set<Integer> d = new HashSet<>(deque);
                if(d.size() > max){
                    max = d.size();
                }
                deque.remove();
            }

        }
        System.out.println(max);
        in.close();
    }



}
