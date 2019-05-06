package com.app.rest.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class Utils {

    private  final  Random RANDOM = new SecureRandom();
    private  final  String ALPHABETH = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private  final  int ITERATIONS = 1000;
    private  final  int KEY_LENGTH = 265;

    public String generateUserId(int length){
        return generateRandomString(length);
    }

    private String generateRandomString(int length) {
        StringBuilder returnValue = new StringBuilder(length);
        for (int i = 0; i < length; i++){
            returnValue.append(ALPHABETH.charAt(RANDOM.nextInt(ALPHABETH.length())));
        }

        return new String(returnValue);
    }

}
