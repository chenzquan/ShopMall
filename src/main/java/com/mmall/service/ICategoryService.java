package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;


import java.util.List;


public interface ICategoryService {

    /**
     * 添加 分类
     * @param categotyName
     * @param parentId
     * @return
     */
    ServerResponse addCategory(String categotyName,Integer parentId);


    /**
     * 更新分类名称
     * @param categoryId
     * @param categoryName
     * @return
     */
    ServerResponse<String> updateCategoryName(Integer categoryId, String categoryName);

    /**
     * 根据 parent_id 去查  查相同的parent_id
     * @param categoryId
     * @return
     */
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);

    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);
}
