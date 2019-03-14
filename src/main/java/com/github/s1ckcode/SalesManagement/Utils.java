package com.github.s1ckcode.SalesManagement;

import com.github.s1ckcode.SalesManagement.User.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Utils {

    public static double getHitrate(User user) {
        return 0.0;
    }

    public static double getAvgSales(User user) {
        return 0.0;
    }

    public static double getAllSales(User user) {
        return 0.0;
    }

    public static String hashMyPassword(String password) {
        BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
        return bCryptEncoder.encode(password);
    }


}
