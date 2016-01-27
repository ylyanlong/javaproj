package com.yl.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/1/19.
 */
public class JsonWrite2entity1 {

    public static void main(String[] args){
        ObjectMapper objectMapper = new ObjectMapper();

        User user = null;
        try {
            user = objectMapper.readValue(new File("user_1.json"), User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("info:" + user.toString() );
    }
}
