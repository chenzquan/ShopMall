package com.mmall.common;

import com.google.common.collect.Sets;

import java.util.Set;

public class Const {

    public static String CURRENT_USER = "CURRENT_USER";
    public static String EMAIL = "EMAIL";

    public static String USERNAME = "USERNAME";

    public interface Role{
        int ROLE_CUSTOMER = 0;  //用户
        int ROLE_ADMIN = 1;  // 管理员
    }

    public enum  ProductStatusEnum{
        ON_SALE(1,"在线");
        private int code;
        private String value;

        ProductStatusEnum(int code,String value){
            this.code = code;
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }
    }

    public interface ProductListOrderBy{
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc","price_asc");
    }


    public interface Cart{

        int CHECKED = 1; //即购物车选中状态
        int UN_CHECKED = 0; //购物车中未选中状态

        String LIMIT_NUM_FAIL = "LIMIT_NUM_FAIL";  //库存 不足
        String LIMIT_NUM_SUCCESS = "LIMIT_NUM_SUCCESS";  //库存 足
    }

    public interface AlipayCallback{
        String TRADE_STATUS_WAIT_BUYER_PAY = "WAIT_BUYER_PAY";
        String TRADE_STATUS_TRADE_SUCCESS = "TRADE_SUCCESS";

        String RESPONSE_SUCCESS = "SUCCESS";
        String RESPONSE_FAILED = "FAILED";
    }

    public enum OrderStatusEnum{

        CANCELED(0,"已取消"),
        NO_PAY(10,"未支付"),
        PAID(20,"已付款"),
        SHIPPED(40,"已发货"),
        ORDER_SUCCESS(50,"订单完成"),
        ORDER_CLOSE(60,"订单关闭");


        private String value;
        private int code;

        OrderStatusEnum(int code,String value){
            this.code = code;
            this.value = value;
        }

        public String getValus() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum PayPlatformEnum{
        ALIPAY(1,"支付宝");

        private int code;
        private String value;

        PayPlatformEnum(int code,String value){
            this.code = code;
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }
    }


    public enum  PaymentTypeEnum{
        ONLINE_PAY(1,"在线支付");

        private int code;
        private String value;

        PaymentTypeEnum(int code,String value){
            this.code = code;
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }


        public static PaymentTypeEnum codeOf(int code){
            for(PaymentTypeEnum paymentTypeEnum : values()){
                if(paymentTypeEnum.getCode() == code){
                    return paymentTypeEnum;
                }
            }
            throw new RuntimeException("么有找到对应的枚举");
        }

    }

}
