package com.imooc.order.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS(0,"成功"),
    PARAMS_ERROR(1,"参数错误"),
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"库存不足"),
    ORDER_MASTER_NOT_EXIST(12,"订单不存在"),
    ORDER_DETAIL_NOT_EXIST(13,"订单详情不存在"),
    ORDER_STATUS_ERROR(14,"订单状态不正确"),
    ORDER_STATUS_UPDATE_ERROR(15,"订单状态更新失败"),
    ORDER_PAY_STATUS_ERROR(16,"订单支付状态不正确"),
    CART_EMPTY(17,"购物车为空"),
    ORDER_OWNER_ERROR(18,"用户订单不匹配"),
    ORDER_NOT_EXIST(19,"查询订单不存在"),
    WECHAT_MP_ERROR(20,"微信公众账号方面错误"),
    WX_NOTIFY_AMOUNT_VERIFY_ERROR(21,"微信异步通知金额校验出错"),
    ORDER_CANCEL_SUCCESS(22,"订单取消成功"),
    ORDER_FINISH_SUCCESS(23,"订单完结成功"),
    PRODUCT_STATUS_ERROR(24,"商品状态不正确"),
    PRODUCT_UPDATE_ERROR(25,"商品更新出错"),
    PRODUCT_CATEGORY_EXIST(26,"该品类type已存在"),
    PRODUCT_CATEGORY_NOT_EXIST(27,"商品品类不存在"),
    PRODUCT_CATEGORY_CAN_NOT_DELETE(28,"商品品类下还有商品存在,品类不能删除"),
    LOGIN_FAIL(29,"登录失败"),
    LOGOUT_FAIL(30,"登出失败"),
    LOGOUT_SUCCESS(31,"登出成功")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
