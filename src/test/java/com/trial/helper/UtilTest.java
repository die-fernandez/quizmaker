package com.trial.helper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.junit.Test;
import java.util.Scanner;

/**
 * Created by diego.fernandez on 12/2/15.
 */
public class UtilTest {

    public static void main(String[] args) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Scanner in = new Scanner(System.in);
        System.out.println(encoder.encode(in.nextLine()));
    }

}
