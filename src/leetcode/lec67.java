package leetcode;

import java.math.BigInteger;

public class lec67 {
    public String addBinary(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);

        return x.add(y).toString(2);
    }
}
