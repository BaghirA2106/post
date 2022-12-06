package com.post.az.main;

import java.math.RoundingMode;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    //    public static void main(String[] args) {
//
//
//        DecimalFormat df = new DecimalFormat("#####.0");
//
//        Double jobSalary = Double.parseDouble("254179.29478555");
//
//        double incomeTax_14 = 14; // Gəlir vergisi
//        double incomeTax_25 = 25;
//        double stateSocialProtectionTax_3 = 3;
//        double stateSocialProtectionTax_10 = 10; // DSFM
//        double joblessTax_0_5 = 0.5; // Işsizliklə bağlı
//        double its_2 = 2;
//        double its_0_5 = 0.5;  // Icbari tibbi sığorta
//
//        double nettIncome = 0;
//
//        double incomeTax = Double.parseDouble(df.format(jobSalary <= 2500 ? ((jobSalary - 200) * incomeTax_14 / 100) : (350 + (jobSalary - 2500) * incomeTax_25 / 100)));
//        incomeTax = incomeTax < 0 ? 0 : incomeTax;
//
//        double stateSocialProtectionTax = Double.parseDouble(df.format(jobSalary * stateSocialProtectionTax_3 / 100));
//        stateSocialProtectionTax = stateSocialProtectionTax < 0 ? 0 : stateSocialProtectionTax;
//
//        double joblessTax = Double.parseDouble(df.format(jobSalary * joblessTax_0_5 / 100));
//        joblessTax = joblessTax < 0 ? 0 : joblessTax;
//
//        double its = Double.parseDouble(df.format(jobSalary <= 8000 ? (jobSalary * its_2 / 100) : (160 + ((jobSalary - 8000) * its_0_5 / 100))));
//        its = its < 0 ? 0 : its;
//
//        nettIncome = Double.parseDouble(df.format((jobSalary - incomeTax - stateSocialProtectionTax - joblessTax - its)));
//        System.out.println(nettIncome);
//
//    }
    public static double round2(double number, int scale) {
        int pow = 10;
        for (int i = 1; i < scale; i++)
            pow *= 10;
        double tmp = number * pow;
        return ((double) ((int) ((tmp - (int) tmp) >= 0.5f ? tmp + 1 : tmp))) / pow;
    }

    public static void main(String[] args) {
//        System.out.println(round2(12.43242342342429942342, 2));

        double incomeTax_14 = 14; // Gəlir vergisi
        double incomeTax_25 = 25;
        double stateSocialProtectionTax_3 = 3;
        double stateSocialProtectionTax_10 = 10; // DSFM
        double joblessTax_0_5 = 0.5; // Işsizliklə bağlı
        double its_2 = 2;
        double its_0_5 = 0.5;  // Icbari tibbi sığorta

        double nettIncome = 0;

        double jobSalary = 5234.05;

        double incomeTax = round2((jobSalary <= 2500 ? ((jobSalary - 200) * incomeTax_14 / 100) : (350 + (jobSalary - 2500) * incomeTax_25 / 100)), 2);
        incomeTax = incomeTax < 0 ? 0 : incomeTax;

        double stateSocialProtectionTax = round2((jobSalary * stateSocialProtectionTax_3 / 100), 2);
        stateSocialProtectionTax = stateSocialProtectionTax < 0 ? 0 : stateSocialProtectionTax;

        double joblessTax = round2((jobSalary * joblessTax_0_5 / 100), 2);
        joblessTax = joblessTax < 0 ? 0 : joblessTax;

        double its = round2((jobSalary <= 8000 ? (jobSalary * its_2 / 100) : (160 + ((jobSalary - 8000) * its_0_5 / 100))), 2);
        its = its < 0 ? 0 : its;


        nettIncome = round2((jobSalary - incomeTax - stateSocialProtectionTax - joblessTax - its), 2);

        String res = nettIncome + "";
        String arr[] = {"5", "6", "7", "8", "9"};
        for (int i = 0; i < arr.length; i++) {
            if (res.substring(res.length() - 1).length() != 1 && res.substring(res.length() - 1, res.length()).equals(arr[i])) {
                nettIncome += 0.01;
            }
        }

        System.out.println(nettIncome);
    }
}
