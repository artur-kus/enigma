package org.example.helper;

public class GeneralUtil {

    public static boolean isNullOrZero(Float object){
        return object == null || object == 0;
    }

    public static boolean isNullOrEmpty(String str){
        return str == null || str.isEmpty();
    }
}
