package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.vo.OrderVo;

import java.util.Map;


public interface IOrderService {
    ServerResponse pay(Long orderNo, Integer userId, String path);

    ServerResponse aliCallback(Map<String, String> params);

    ServerResponse queryOrderPayStatus(Integer id, Long orderNo);

    ServerResponse createOrder(Integer id, Integer shippingId);

    ServerResponse cancel(Integer id, Long orderNo);

    ServerResponse getOrderCartProduct(Integer id);

    ServerResponse getOrderDetail(Integer id, Long orderNo);

    ServerResponse<PageInfo> getOrderList(Integer id, int pageNum, int pageSize);


//    ——————————————————————————————————————————————————————————————
    // 后台的接口
    ServerResponse<PageInfo> manageList(int pageNum, int pageSize);

    ServerResponse<OrderVo> manageDetail(Long orderNo);

    ServerResponse<PageInfo> manageSearch(Long orderNo,int pageNum,int pageSize);

    ServerResponse<String> manageSendGoods(Long orderNo);

}
