package com.yuhao.model;

import lombok.Data;

/**
 * @description：系统日志bo
 * @author：Mr.Yu
 * @date：2019/4/2 15:41
 * @version：V1.0
 */
@Data
public class SysLogBO {


    private String className;

    private String methodName;

    private String params;

    private Long exeuTime;

    private String remark;

    private String createDate;

}
