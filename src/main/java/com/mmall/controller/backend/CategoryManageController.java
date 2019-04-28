package com.mmall.controller.backend;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;
import com.mmall.service.ICategoryService;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping(value = "/manage/category")
public class CategoryManageController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ICategoryService iCategoryService;


    /**
     * 增加 category
     * @param categoryName 商品类别名称
     * @param parentId
     * @param
     * @return
     */
    @RequestMapping(value = "add_category.do")
    @ResponseBody
    public ServerResponse<String> addCategory(String categoryName, @RequestParam(value = "parentId",defaultValue = "0") int parentId, HttpServletRequest httpServletRequest){

//        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
//        if(StringUtils.isEmpty(loginToken)){
//            return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
//        }
//
//        String userJsonStr = RedisPoolUtil.get(loginToken);
//        User user = JsonUtil.string2Obj(userJsonStr,User.class);
//        if(user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录");
//        }
//        //校验 是否是 管理员
//        if(iUserService.checkAdminRole(user).isSuccess()){
//            //是管理员
//            return iCategoryService.addCategory(categoryName,parentId);
//        }else{
//            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
//        }
        //全部通过拦截器验证是否登录以及权限
        return iCategoryService.addCategory(categoryName,parentId);

    }

    /**
     * 设置 商品类别 名字
     * @param categoryId
     * @param categoryName
     * @param
     * @return
     */
    @RequestMapping(value = "set_category_name.do")
    @ResponseBody
    public ServerResponse<String> setCategoryName(Integer categoryId,String categoryName,HttpServletRequest httpServletRequest){
//        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
//        if(StringUtils.isEmpty(loginToken)){
//            return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
//        }
//
//        String userJsonStr = RedisPoolUtil.get(loginToken);
//        User user = JsonUtil.string2Obj(userJsonStr,User.class);
//        if(user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录");
//        }
//
//        if(iUserService.checkAdminRole(user).isSuccess()){
//            //更新categoryName
//            return iCategoryService.updateCategoryName(categoryId,categoryName);
//        }else{
//            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
//        }
        return iCategoryService.updateCategoryName(categoryId,categoryName);
    }

    @RequestMapping(value = "get_category.do")
    @ResponseBody
    public ServerResponse<List<Category>> getChildrendParallelCategory(HttpServletRequest httpServletRequest, @RequestParam(value = "categoryId",defaultValue = "0") Integer categoryId){
//        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
//        if(StringUtils.isEmpty(loginToken)){
//            return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
//        }
//
//        String userJsonStr = RedisPoolUtil.get(loginToken);
//        User user = JsonUtil.string2Obj(userJsonStr,User.class);
//        if(user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录");
//        }
//
//        if(iUserService.checkAdminRole(user).isSuccess()){
//            //查询子节点的category信息,并且不递归,保持平级  根据parentId 去查
//            ServerResponse<List<Category>> response = iCategoryService.getChildrenParallelCategory(categoryId);
//          //  return iCategoryService.getChildrenParallelCategory(categoryId);
//            if(CollectionUtils.isEmpty(response.getData())){
//                return ServerResponse.createByErrorMessage("未找到该品类");
//            }else{
//                return response;
//            }
//        }else{
//            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
//        }
        return iCategoryService.getChildrenParallelCategory(categoryId);
    }


    @RequestMapping(value = "get_deep_category.do")
    @ResponseBody
    public ServerResponse<List<Integer>> getCategoryAndDeepChildrenCategory(HttpServletRequest httpServletRequest,@RequestParam(value = "categoryId",defaultValue = "0") Integer categoryId){
//        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
//        if(StringUtils.isEmpty(loginToken)){
//            return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
//        }
//
//        String userJsonStr = RedisPoolUtil.get(loginToken);
//        User user = JsonUtil.string2Obj(userJsonStr,User.class);
//        if(user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录");
//        }
//        if(iUserService.checkAdminRole(user).isSuccess()){
//            //查询当前节点的 id 和 递归子节点的id
//            // 0->10000->100000
//            return iCategoryService.selectCategoryAndChildrenById(categoryId);
//        }else{
//            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
//        }
        return iCategoryService.selectCategoryAndChildrenById(categoryId);

    }



}
