package com.post.az.main;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {


        String str = LocalDate.now().minusDays(10).toString();
        String date = "";

        date = date + str.substring(0,4);
        date = date + str.substring(5, 7);
        date = date + str.substring(8, 10);
        System.out.println(str
        );

    }
}
