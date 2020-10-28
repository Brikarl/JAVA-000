package Week_02.homework;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @Author: Yunkai Bo
 * @Date: 2020/10/28 22:14
 * @Version 1.0
 */
public class OKHttpDemo {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        try {
            Request request = new Request.Builder().url("http://localhost:80/test").build();
            Response response = client.newCall(request).execute();
            byte[] bytes = response.body().bytes();
            System.out.println(new String(bytes, "UTF-8"));
        } finally {
            client.clone();
        }
    }
}