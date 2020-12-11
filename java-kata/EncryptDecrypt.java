import java.math.BigInteger;

//This program uses the RSA algorithm concept to
//encrypt a secret number "a" using encryption key "e"
//and decryption key "d" and modulus "m":
public class EncryptDecrypt {

    public static void main(String[] args) {
        BigInteger m = BigInteger.valueOf(3127);
        BigInteger e = BigInteger.valueOf(-1);
        BigInteger d = BigInteger.valueOf(1149);
        BigInteger a = BigInteger.valueOf(-1);

        System.out.println("\nstarting value: a = " + a);

        //BigInteger b = a.modPow(e, m);
        BigInteger b = BigInteger.valueOf(123);
        System.out.println("encrypt to b = " + b);

        BigInteger decrypt = b.modPow(d, m);
        System.out.println("decrypt back to a = " + decrypt);

    }
}//END class EncryptDecrypt.................................
