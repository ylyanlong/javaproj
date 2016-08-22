package com.yl.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/6/8.
 */
public class StringParse1 {
    public static void main(String[] args){
        String str = "id=2131559106,class=android.widget.Button";
        Map<String, String> key2value = parseClickEvent(str);
        Set<Map.Entry<String, String> > entries = key2value.entrySet();
        for(Map.Entry<String, String> entry: entries){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static Map<String, String> parseClickEvent(String input){
        Map<String, String> key2value = new HashMap<>();

        String[] name2value = input.split(",");
        for(String ele: name2value){
            if(ele.contains("=")){
                String[] params = ele.split("=");
                if(params.length == 2){
                    key2value.put(params[0], params[1]);
                }
            }
        }

        return key2value;
    }

}
