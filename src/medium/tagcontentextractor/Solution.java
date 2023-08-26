package medium.tagcontentextractor;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        String regexString = "<(.+)>([^<]+)<\\/(\\1)>";
        Pattern regexPattern = Pattern.compile(regexString);
        while(testCases>0){
            String line = in.nextLine();
            Matcher matcher = regexPattern.matcher(line);
            boolean found = false;

            while(matcher.find()) {
                System.out.println(matcher.group(2));
                found = true;
            }
            if(!found){
                System.out.println("None");
            }
            //Write your code here

            testCases--;
        }
    }
}

