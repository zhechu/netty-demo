package com.wise;

import org.junit.Test;

/**
 * @author lingyuwang
 * @date 2019-06-23 15:59
 */
public class AssertTest {

    @Test
    public void assertTest() {
        String s = null;
        assert s!=null?true:false;
        assert false;
        System.out.println("end");
    }

}
