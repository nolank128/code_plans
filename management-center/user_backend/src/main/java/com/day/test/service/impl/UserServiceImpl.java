package com.day.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.day.test.common.ErrorCode;
import com.day.test.exception.BusinessException;
import com.day.test.mapper.UserMapper;
import com.day.test.model.domain.User;
import com.day.test.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.day.test.contant.UserConstant.USER_LOGIN_STATE;

/*
* 用户服务实现类
*
* */

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Resource
    private UserMapper userMapper;
    /*盐值，混淆密码*/
    private static final String SALT ="ktrol";

    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword,String planetCode) {
        //1.校验

        if (StringUtils.isAllBlank(userAccount,userPassword,checkPassword)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"参数为空");
        }

        //2.校验用户
        if (userAccount.length()<4){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"用户账户太短");
        }

        if (userPassword.length()<8 || checkPassword.length()<8){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"用户账号密码过短");

        }
        if (planetCode.length()>5){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"编号太长" );
        }


        //账户检测是否包含特殊字符
        String validPattern ="[`~!@#$%^&()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&（）——+|{}【】‘；：“”’。，、？]";
        Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
        if (matcher.find()) {
            return -1;
        }

        //密码和校验密码相同
        if (!userPassword.equals(checkPassword)){
            return -1;
        }

        //检测账户是否重复,检测的过程中，有查询数据库的过程，所以顺序稍微放到后面可以进行减少性能损失。
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("userAccount",userAccount);
        long count=userMapper.selectCount(queryWrapper);
        if (count>0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"账户重复");
        }

        //编号不重复
        queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("planetCode",planetCode);
         count=userMapper.selectCount(queryWrapper);
        if (count>0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"编号重复");
        }


        //加密
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT+userPassword).getBytes());


        //插入数据
        User user=new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(encryptPassword);
        user.setPlanetCode(planetCode);
        boolean saveResult=this.save(user);
        if (!saveResult){
            return -1;
        }
        return user.getId();
    }

    @Override
    public User userLogin(String userAccount, String userPassword, HttpServletRequest request) {
        //1.校验
        if (StringUtils.isAllBlank(userAccount,userPassword)){
            return null;
        }
        //2.校验用户
        if (userAccount.length()<4){
            return null;
        }
        if (userPassword.length()<8 ){
            return null;
        }

        //账户检测是否包含特殊字符
        String validPattern ="[`~!@#$%^&()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&（）——+|{}【】‘；：“”’。，、？]";
        Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
        if (matcher.find()) {
            return null;
        }

        //加密
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT+userPassword).getBytes());
        //查询用户是否存在
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("userAccount",userAccount);
        queryWrapper.eq("userPassword",encryptPassword);
        User user = userMapper.selectOne(queryWrapper);
        //用户不存在
        if (user==null){
            log.info("user login failed,user cannot match userPassword");
            return null;
        }

        //3.用户脱敏 ,隐藏敏感信息
        User safetyUser=getSafetyUser(user);
        //4.记录用户登录态
        request.getSession().setAttribute(USER_LOGIN_STATE,safetyUser);
        return safetyUser;
    }

    /**
     * 用户脱敏
     * @param originUser
     * @return
     */
    @Override
    public User getSafetyUser(User originUser){
        if (originUser==null){
            return null;
        }
        User safetyUser=new User();
        safetyUser.setId(originUser.getId());
        safetyUser.setUsername(originUser.getUsername());
        safetyUser.setUserAccount(originUser.getUserAccount());
        safetyUser.setAvatarUrl(originUser.getAvatarUrl());
        safetyUser.setGender(originUser.getGender());
        safetyUser.setPhone(originUser.getPhone());
        safetyUser.setEmail(originUser.getEmail());
        safetyUser.setPlanetCode(originUser.getPlanetCode());
        safetyUser.setUserRole(originUser.getUserRole());
        safetyUser.setUserStatus(originUser.getUserStatus());
        safetyUser.setCreateTime(originUser.getCreateTime());
        return safetyUser;
    }

    /**
     * 用户注销
     * @param request
     * @return
     */
    @Override
    public int userLogout(HttpServletRequest request) {
        //移除登录态
        request.getSession().removeAttribute(USER_LOGIN_STATE);
        return 1;
    }


}




