package com.yl.json;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/5.
 */
public class HttpTest1 {
    public static void main(String[] args){

        /*HttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://cul.service.yy.com:9888/cultopcucount?topsids=96756925");
        //
        // 调用HttpClient对象的execute方法获得响应
        HttpResponse response = null;
        try {
            response = client.execute(get);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 调用HttpResponse对象的getEntity方法得到响应实体
        HttpEntity httpEntity = response.getEntity();

        // 使用EntityUtils工具类得到响应的字符串表示
        String result = null;
        try {
            result = EntityUtils.toString(httpEntity, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);*/
        //

        try {
            httpclientPost();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void httpclientPost() throws Exception{

        // 创建HttpClient对象
        HttpClient client = HttpClients.createDefault();

        // 创建POST请求
        HttpPost post = new HttpPost("http://cul.service.yy.com:9888/cultopcucount?");

        // 创建一个List容器，用于存放基本键值对（基本键值对即：参数名-参数值）
        List<BasicNameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("topsids", "96756925")); // "96756925"
        // parameters.add(new BasicNameValuePair("age", "25"));

        // 向POST请求中添加消息实体
        post.setEntity(new UrlEncodedFormEntity(parameters, "utf-8"));

        // 得到响应并转化成字符串
        HttpResponse response = client.execute(post);
        HttpEntity httpEntity = response.getEntity();
        String result = EntityUtils.toString(httpEntity,"utf-8");
        System.out.println(result);
    }

}
