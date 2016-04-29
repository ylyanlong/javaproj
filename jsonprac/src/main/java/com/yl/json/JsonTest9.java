package com.yl.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by Administrator on 2016/4/6.
 */
public class JsonTest9 {
    private static ObjectMapper objectMapper = null;

    public static void main(String[] args){
        AnchorExitInfo anchorExitInfo = new AnchorExitInfo(58964, 0.5987, 565, 56, 50);

        // {"uid":58964,"en_uv":85,"out_uv":54,"liushiRate":0.5987,"rank":565}
        String rtn = null;
        // String rtn = "{\"uid\":58964,\"en_uv\":85,\"out_uv\":54,\"liushiRate\":0.5987,\"rank\":565}";

        objectMapper = new ObjectMapper();

        try {
            rtn = objectMapper.writeValueAsString(anchorExitInfo);
            System.out.println(rtn);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            AnchorExitInfo anchorExitInfo2 = objectMapper.readValue(rtn, AnchorExitInfo.class);
            System.out.println(anchorExitInfo2.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
