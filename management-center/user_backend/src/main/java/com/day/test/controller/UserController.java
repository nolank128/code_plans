package com.day.test.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.day.test.common.BaseResponse;
import com.day.test.common.ErrorCode;
import com.day.test.common.ResultUtils;
import com.day.test.exception.BusinessException;
import com.day.test.model.domain.User;
import com.day.test.model.domain.request.UserLoginRequest;
import com.day.test.model.domain.request.UserRegisterRequest;
import com.day.test.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

import static com.day.test.contant.UserConstant.ADMIN_ROLE;
import static com.day.test.contant.UserConstant.USER_LOGIN_STATE;

/*
* 用户接口
* */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public BaseResponse<Long> userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        if (userRegisterRequest ==null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        String userAccount=userRegisterRequest.getUserAccount();
        String userPassword=userRegisterRequest.getUserPassword();
        String checkPassword=userRegisterRequest.getCheckPassword();
        String planetCode =userRegisterRequest.getPlanetCode();

        if (StringUtils.isAllBlank(userAccount,userPassword,checkPassword)){
            return null;
        }
        long result=userService.userRegister(userAccount, userPassword, checkPassword,planetCode);
        return ResultUtils.success(result);

    }


    @PostMapping("/login")
    public BaseResponse<User> userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        if (userLoginRequest ==null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        String userAccount=userLoginRequest.getUserAccount();
        String userPassword=userLoginRequest.getUserPassword();

        if (StringUtils.isAllBlank(userAccount,userPassword)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
         User user=userService.userLogin(userAccount, userPassword,request);
        return ResultUtils.success(user);
    }

    @PostMapping("/logout")
    public BaseResponse<Integer> userLogout(HttpServletRequest request) {
        if (request == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        int result= userService.userLogout(request);
        return ResultUtils.success(result);
    }

    @GetMapping("/current")
    public BaseResponse<User> getCurrentUser(HttpServletRequest request){
        Object userObj=request.getSession().getAttribute(USER_LOGIN_STATE);
        User currentUser =(User) userObj;
        if (currentUser==null){
            throw new BusinessException(ErrorCode.NOT_LOGIN);
        }
        long userId=currentUser.getId();
        //检验用户是否合法
        User user=userService.getById(userId);
        User safeUser= userService.getSafetyUser(user);
        return ResultUtils.success(safeUser);
    }


    @GetMapping("/search")
    public BaseResponse<List<User>> searchUsers(String username,HttpServletRequest request){
        if (!isAdmin(request)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"参数为空");
        }

        QueryWrapper<User> queryWrapper =new QueryWrapper<>();
        if (StringUtils.isNotBlank(username)){
            queryWrapper.like("username",username);
        }

        /*
        * java 8
        * */
        List<User> userList= userService.list(queryWrapper);
        List<User> list= userList.stream().map(user -> userService.getSafetyUser(user)).collect(Collectors.toList());
        return ResultUtils.success(list);
    }



    @PostMapping ("/delete")
    public BaseResponse<Boolean> deleteUser(@RequestBody long id,HttpServletRequest request){
        if (!isAdmin(request)){
            throw new BusinessException(ErrorCode.NO_AUTH);
        }

        if (id<=0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        boolean b= userService.removeById(id);
        return ResultUtils.success(b);
    }


    /**
     * 是否为管理员
     * @param request
     * @return
     */


    private boolean isAdmin(HttpServletRequest request){
        //仅管理员可查询
        Object userObj =request.getSession().getAttribute(USER_LOGIN_STATE);
        User user=(User) userObj;
        return user!=null || user.getUserRole()==ADMIN_ROLE;
    }


}
