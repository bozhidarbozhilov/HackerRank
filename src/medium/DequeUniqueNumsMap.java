package medium;

import java.util.*;

public class DequeUniqueNumsMap {
    public static void solution(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Deque<Integer> deque = new ArrayDeque<>(n);
        Map<Integer, Integer> map = new HashMap<>();
        int max=0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            map.put(num, 1);
            if(deque.size()==m){
                if(map.keySet().size() > max){
                    max = map.keySet().size();
                }
                int last = deque.remove();
                if(!deque.contains(last)){
                    map.remove(last);
                }


            }

        }
        System.out.println(max);
        in.close();
    }
}
