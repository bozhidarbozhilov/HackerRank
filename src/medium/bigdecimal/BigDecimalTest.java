package medium.bigdecimal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BigDecimalTest {
    public static void main(String[] args) throws IOException {
        ///  sort big numbers
//        Scanner scanner = new Scanner(System.in);
//        String tmp = "";
//        int n = Integer.parseInt(scanner.nextLine());
//        String[] bigArray = new String[n];
//        for (int i = 0; i < n; i++) {
//            bigArray[i] = scanner.nextLine();
//        }
//
//        Arrays.sort(bigArray, new Comparator<String>(){
//            @Override
//            public int compare(String o1, String o2) {
//                if(o1==null || o2==null){
//                    return 0;
//                }
//                return new BigDecimal(o2).compareTo(new BigDecimal(o1));
//            }
//        });
//        for (int i = 0; i < n; i++) {
//            System.out.println(bigArray[i]);
//        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /// Primality Test
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        String n = bufferedReader.readLine();
//
//        bufferedReader.close();
//
//        String result = new BigInteger(n).isProbablePrime(1)? "prime": "not prime";
//        System.out.println(result);
///////////////////////////////////////////////////////////////////////////////////////////////////////
        // Java 2d array
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        List<List<Integer>> arr = new ArrayList<>();
//
//        IntStream.range(0, 6).forEach(i -> {
//            try {
//                arr.add(
//                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                                .map(Integer::parseInt)
//                                .collect(toList())
//                );
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        bufferedReader.close();
//        int maxSum = Integer.MIN_VALUE;
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                if(arr.get(i).get(j) >= -9 && arr.get(i).get(j)<=9){
//                    int sum = arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2) + arr.get(i+1).get(j+1) + arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2);
//                    if(sum>maxSum){
//                        maxSum = sum;
//                    }
//                }
//            }
//        }
//        System.out.println(maxSum);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // subarray
//        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.nextLine());
//        String[] arr = sc.nextLine().split(" ");
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = Integer.parseInt(arr[i]);
//        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        int count=0;
//        for(int j=0;j<n;j++){
//            int sum=0;
//            for(int k=j;k<n;k++){
//                sum=nums[k]+sum;
//                if(sum<0){
//                    count++;
//                }
//            }
//        }
//        System.out.println(count);
        //int subarrayWidth = 1;
        //int counter = 0;
//        while(subarrayWidth <= n){
//            for (int i = 0; i <= n-subarrayWidth; i++) {
//                int sum = 0;
//                for (int j = i; j < i+subarrayWidth; j++) {
//                    sum += nums[j];
//                }
//                if(sum<0){
//                    counter++;
//                }
//            }
//            subarrayWidth++;
//        }

        //System.out.println(counter);

    }

}
