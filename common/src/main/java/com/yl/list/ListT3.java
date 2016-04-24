package com.yl.list;

import com.yl.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/5.
 */
public class ListT3 {
    public static void main(String[] args){
        List<User> list = new ArrayList<>();

        User user1 = new User(1, "tom", 14);
        User user2 = new User(2, "john", 24);
        list.add(user1);
        list.add(user2);

        for(User user: list){
            user.setAge(user.getAge() + 20);
            // System.out.println(user.toString() );
        }

        for(User user: list){
            System.out.println("ele:" + user.toString() );
        }

        // List<Long> list2 = null;
        List<Long> list2 = new ArrayList<>();
        System.out.println("list2 size:" + list2.size());
        for(Long ele: list2){
            System.out.printf("list2 ele: " + ele);
        }
        System.out.println("list2 end");

    }

}
