package com.wise.protobuf;

import org.junit.Test;

/**
 * @author lingyuwang
 * @date 2019-06-08 16:41
 */
public class StudentProtoTest {

    @Test
    public void build() throws Exception {
        StudentProto.Student student = StudentProto.Student.newBuilder().setName("张三").setAge(20).setAddress("广州").build();

        byte[] studentByteArray = student.toByteArray();

        StudentProto.Student studentSource = StudentProto.Student.parseFrom(studentByteArray);

        System.out.println(studentSource.getName()); // 张三
        System.out.println(studentSource.getAge()); // 20
        System.out.println(studentSource.getAddress()); // 广州
    }

}
