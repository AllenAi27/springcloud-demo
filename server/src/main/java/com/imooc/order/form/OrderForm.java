package com.imooc.order.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;


/**
 *进行表单验证和数据接受
 */

@Data
public class OrderForm {

    @NotEmpty(message = "买家姓名必填")
    private String name;

    @NotEmpty(message = "买家手机号必填")
    private String phone;

    @NotEmpty(message = "买家地址必填")
    private String address;

    @NotEmpty(message = "买家openid必填")
    private String openid;

    @NotEmpty(message = "购物车不能为空")
    private String items;
}
