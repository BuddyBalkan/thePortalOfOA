package com.seeyon.portal.test;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class TicketTest {

    @Test
    public void test1(){
        String string = "OA系统和门户系统，什么几把玩意嘛";

        try {
            byte[] bytes = string.getBytes("UTF-8");
            System.out.println(bytes);
            String s = new String(bytes, "UTF-8");
            System.out.println(s);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
