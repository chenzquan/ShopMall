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



}
