package com.mmall.service;


import com.mmall.common.ServerResponse;
import com.mmall.vo.CartVo;

public interface ICartService {

    ServerResponse<CartVo> list(Integer id);

    ServerResponse<CartVo> add(Integer id, Integer productId, Integer count);

    ServerResponse<CartVo> update(Integer id, Integer productId, Integer count);

    ServerResponse<CartVo> deleteProduct(Integer id, String productIds);

    ServerResponse<CartVo> selectOrUnSelect(Integer id, Integer productId, Integer checked);

    ServerResponse<Integer> getCartProductCount(Integer id);
}
