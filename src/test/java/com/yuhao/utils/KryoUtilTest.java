package com.yuhao.utils;

import com.yuhao.model.Student;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @description：
 * @author：Mr.Yu
 * @date：2019/4/2 15:14
 * @version：V1.0
 */
public class KryoUtilTest {

    @Test
    public void test() {
        Student student = new Student("余浩", "男", 22);
        //将对象【及类型】序列化为字节数组
        byte[] s1 = KryoUtil.writeToByteArray(student);
        System.out.println("将对象【及类型】序列化为字节数组：" + s1.length);
        //将对象【及类型】序列化为 String
        String s2 = KryoUtil.writeToString(student);
        System.out.println("将对象【及类型】序列化为 String：" + s2);
        //将字节数组反序列化为原对象
        Student student1 = KryoUtil.readFromByteArray(s1);
        System.out.println("将字节数组反序列化为原对象：" + student1.toString());
        //将 String 反序列化为原对象
        Student student2 = KryoUtil.readFromString(s2);
        System.out.println("将 String 反序列化为原对象：" + student2.toString());

        System.out.println("-----------------------------------------------");

        Student student11 = new Student("张三", "女", 18);
        byte[] sss1 = KryoUtil.writeObjectToByteArray(student11);
        System.out.println("将对象序列化为字节数组：" + sss1.length);

        String sss2 = KryoUtil.writeObjectToString(student11);
        System.out.println("将对象序列化为 String：" + sss2);

        Student student111 = KryoUtil.readObjectFromByteArray(sss1, Student.class);
        System.out.println("将字节数组反序列化为原对象：" + student111.toString());

        Student student222 = KryoUtil.readObjectFromString(sss2, Student.class);
        System.out.println("将 String 反序列化为原对象：" + student222.toString());
    }

}