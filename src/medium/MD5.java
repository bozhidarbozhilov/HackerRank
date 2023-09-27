package medium;

import javax.xml.datatype.DatatypeFactory;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;


public class MD5 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        MessageDigest md = MessageDigest.getInstance("SHA256");
        md.update(input.getBytes());
        byte[] digest = md.digest();

        System.out.println(String.format("%064x", new BigInteger(1, digest)));
    }
}
