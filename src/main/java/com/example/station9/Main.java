package com.example.station9;

public class Main {
    public static void main(String[] args) {
        int[] itemPrices1 = {1000, 1100, 1200, 1300};
        int[] itemPrices2 = {1000, 1100, 1200, 1300, 1600, 1800};
        int[] itemPrices3 = {1000, 2100, 3200, 2300};
        System.out.print("カート内: 1000円, 1100円, 1200円, 1300円。期待されるクーポン: A。結果: ");
        test(itemPrices1);
        System.out.print("カート内: 1000円, 1100円, 1200円, 1300円, 1600円, 1800円。期待されるクーポン: B。結果: ");
        test(itemPrices2);
        System.out.print("カート内: 1000円, 2100円, 3200円, 2300円。期待されるクーポン: C。結果: ");
        test(itemPrices3);
    }

    public static void test(int[] itemPrices) {
        // ここから
        // クーポンAパターン
        int a_sum = 0;
        int a_all;
        for (int value : itemPrices) {
            a_sum += value;
        }
        a_all = a_sum;

        // クーポンBパターン
        int b_sum = 0;
        int b_all;
        for (int value : itemPrices) {
            value = value - (value / 10);
            b_sum += value;
        }
        if (b_sum < 5000) {
            b_all = b_sum + 800;
        }
        else {
            b_all = b_sum;
        }

        // クーポンCパターン
        int c_sum = 0;
        int c_all;
        for (int value : itemPrices) {
            if (value >= 2000) {
                value = value - (value / 20);
            }
            c_sum += value;
        }
        if (c_sum < 5000) {
            c_all = c_sum + 800;
        }
        else {
            c_all = c_sum;
        }

        // どのクーポンがいいか
        int[] coupon = {a_all,b_all,c_all};
        int min = coupon[0];
        for (int i = 1; i < coupon.length; i++) {
            if (min > coupon[i]) {
                min = coupon[i];
            }
        }
        if (min == a_all) {
            System.out.println("A");
        }
        else if (min == b_all) {
            System.out.println("B");
        }
        else if (min == c_all) {
            System.out.println("C");
        }
        // ここまで
    }
}
