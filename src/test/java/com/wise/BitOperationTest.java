package com.wise;

import org.junit.Test;

/**
 * @author lingyuwang
 * @date 2019-06-23 15:59
 */
public class BitOperationTest {

    @Test
    public void isPowerOfTwoTest() {
        int val = 0;
        System.out.println((val & -val) == val);

        val = 3;
        System.out.println((val & -val) == val);

        val = 4;
        System.out.println((val & -val) == val);
    }

}
