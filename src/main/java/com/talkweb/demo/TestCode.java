package com.talkweb.demo;

import java.io.UnsupportedEncodingException;

/**
 * @author liuzixuan
 * @date 2020/8/7
 */
public class TestCode {

    public static void main(String[] args) throws UnsupportedEncodingException {
        int status = 0;
        Boolean A = !("ZZ1".contentEquals("ZZ")) && (status ==0);
        Boolean B = "adcd".contentEquals("ZZ") && (status ==1);
        System.out.println(A);
        System.out.println(true || false);
    }
}
