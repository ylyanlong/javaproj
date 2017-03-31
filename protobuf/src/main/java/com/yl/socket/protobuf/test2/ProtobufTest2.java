package com.yl.socket.protobuf.test2;


import com.google.protobuf.InvalidProtocolBufferException;
import com.yl.socket.protobuf.test.PersonEntity;

/**
 * Created by yanlong on 2017/3/31.
 */
public class ProtobufTest2 {
    public static void main(String[] args){
        // 模拟将对象转换为byte[] 方便传输
        // PersonEntity.Person.Builder builder = PersonEntity.Person.newBuilder();
        PersonEntity.Person.Builder builder = PersonEntity.Person.newBuilder();
        builder.setId(1);
        builder.setName("ant");
        builder.setEmail("ghb@soecode.com");

        PersonEntity.Person person = builder.build();
        System.out.println("person:" + person);
        System.out.println("--------------person-byte----------------------------");
        for(byte b: person.toByteArray()){
            System.out.print(b);
        }

        System.out.println("\n--------------person-ByteString----------------------------");
        System.out.println("byteString" + person.toByteString());

        // 模拟接收Byte[], 反序列化成Person类
        byte[] byteArray = person.toByteArray();
        try {
            PersonEntity.Person person2 = PersonEntity.Person.parseFrom(byteArray);
            System.out.println("person2:" + person2);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

    }


}
