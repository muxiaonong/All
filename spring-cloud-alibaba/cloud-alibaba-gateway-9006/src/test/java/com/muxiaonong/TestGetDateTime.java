package com.muxiaonong;

import java.time.ZonedDateTime;

public class TestGetDateTime {
    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now();//默认时区
        System.out.println(zbj);
    }

}