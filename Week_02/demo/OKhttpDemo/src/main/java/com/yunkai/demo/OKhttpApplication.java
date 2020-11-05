package com.yunkai.demo;

import java.io.IOException;

/**
 * @Author: Yunkai Bo
 * @Date: 2020/11/5 11:57
 * @Version 1.0
 */
public class OKhttpApplication {
    public static void main(String[] args) throws IOException {
        HttpClient client = new HttpClient();
        try {
            client.run("http://localhost:8801");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
