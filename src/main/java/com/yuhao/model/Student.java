package com.yuhao.model;

import com.yuhao.aspect.anno.CodeEntityAnno;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @description：具体描述可参考：https://blog.csdn.net/motui/article/details/79012846
 * @author：Mr.Yu
 * @date：2019/4/1 21:41
 * @version：V1.0
 */

//该注解会提供getter、setter、equals、canEqual、hashCode、toString方法。
@Data
@Slf4j
public class Student implements Serializable {

    private String name;

    private String sex;

    private int age;

    public Student() {
        log.info("1111");
    }

    public Student(String name, String sex, int age) {
        super();
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

}
