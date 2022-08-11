package Entities;

import java.util.Random;

public class UtilFunc {
    void generate(String generatedString)
    {
        String upper="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lwr = "abcdefghijklmnopqrstuvwxyz";
        String num = "0123456789";
        String combo = upper+lwr+num;
        Random r = new Random();
        int len = 8;
        char[] pwd = new char[len];
        for(int i = 0;i<len;i++)
        {
            pwd[i]=combo.charAt(r.nextInt(combo.length()));
        }
        generatedString = new String(pwd);
    }
}

