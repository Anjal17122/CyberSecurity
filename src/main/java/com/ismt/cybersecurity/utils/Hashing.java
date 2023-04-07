package com.ismt.cybersecurity.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {

    public static String hash(String hash) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] messageDigest = md.digest(hash.getBytes());
        BigInteger bigInteger = new BigInteger(1,messageDigest);
        return bigInteger.toString(16); //64 characters

    }
}
