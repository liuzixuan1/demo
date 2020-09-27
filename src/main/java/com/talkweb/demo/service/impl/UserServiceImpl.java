package com.talkweb.demo.service.impl;


import com.talkweb.demo.dao.UserMapper;
import com.talkweb.demo.pojo.UserBean;
import com.talkweb.demo.service.UserService;
import com.talkweb.pangu.base.common.pojo.PageBean;
import com.talkweb.pangu.base.common.result.AResultCode;
import com.talkweb.pangu.base.common.result.ResultMap;
import com.talkweb.pangu.base.common.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author liuzixuan
 * @date 2020/9/13
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;

    /**
     * 新增数据
     * @param bean
     * @return
     */
    @Override
    public ResultMap<AResultCode, UserBean> insert(UserBean bean){
        ResultMap<AResultCode, UserBean> result = new ResultMap<AResultCode, UserBean>();
        if(StringUtil.isNull(bean)){
            result.setCode(AResultCode.IS_NULL);
        } else {
            if(StringUtil.isNull(bean.getUser_id())){
                bean.setUser_id(StringUtil.getUUID());
            }
            if(userMapper.countUser(bean.getUsername()) != 0){
                result.setCode(AResultCode.EXIST);
                return result;
            }
            userMapper.insertSelective(bean);
            result.setCode(AResultCode.OK);
            result.setResult(bean);
        }
        return result;
    }


    /**
     * 更新数据
     * @param bean
     * @return
     */
    @Override
    public ResultMap<AResultCode, UserBean> update(UserBean bean){
        ResultMap<AResultCode, UserBean> result = new ResultMap<AResultCode, UserBean>();

        if(StringUtil.isNull(bean)){
            result.setCode(AResultCode.IS_NULL);
        } else if(StringUtil.isNull(bean.getUser_id())){
            result.setCode(AResultCode.MISS_ID);
        } else {
            userMapper.updateSelective(bean);
            result.setCode(AResultCode.OK);
            result.setResult(bean);
        }

        return result;
    }


    /**
     * 根据企业id删除一个或多个
     * @param user_id
     * @return
     */
    @Override
    public ResultMap<AResultCode, UserBean> delete(String user_id){
        ResultMap<AResultCode, UserBean> result = new ResultMap<AResultCode, UserBean>();

        if(StringUtil.isNull(user_id)){
            result.setCode(AResultCode.MISS_ID);
        } else {
            String[] ids = user_id.split(",");
            userMapper.delete(ids);
            result.setCode(AResultCode.OK);
        }

        return result;
    }

    /**
     * 分页查询
     * @param pb
     * @return
     */

    @Override
    public ResultMap<AResultCode, PageBean<UserBean>> pageList(PageBean<UserBean> pb){
        ResultMap<AResultCode, PageBean<UserBean>> result = new ResultMap<AResultCode, PageBean<UserBean>>();

        pb.setData(userMapper.pageList(pb));
        pb.clear();

        result.setCode(AResultCode.OK);
        result.setResult(pb);

        return result;
    }


    /**
     * <b>Summary: 查询列表数据</b>
     * list
     *
     * @param bean
     * @return
     */
    @Override
    public ResultMap<AResultCode, List<UserBean>> listAll(UserBean bean) {
        ResultMap<AResultCode, List<UserBean>> result = new ResultMap<AResultCode, List<UserBean>>();

        List<UserBean> list = userMapper.listAll(bean);
        result.setCode(AResultCode.OK);
        result.setResult(list);

        return result;
    }

    /**
     * 根据企业id查询
     * @param user_id
     * @return
     */
    @Override
    public ResultMap<AResultCode, UserBean> get(String user_id){
        ResultMap<AResultCode, UserBean> result = new ResultMap<AResultCode, UserBean>();

        if(StringUtil.isNull(user_id)){
            return result.setCode(AResultCode.MISS_ID);
        }

        UserBean bean = userMapper.get(user_id);

        if(bean == null) {
            return result.setCode(AResultCode.UNEXIST);
        }

        result.setCode(AResultCode.OK);
        result.setResult(bean);

        return result;
    }
    @Override
    public ResultMap<AResultCode,UserBean> getLogin(String username,String password) {
        ResultMap<AResultCode, UserBean> result = new ResultMap<AResultCode, UserBean>();
        UserBean bean = userMapper.getLogin(username);
        if (bean == null){
            result.setCode(AResultCode.IS_NULL);
        }else if(userMapper.countUser(username)==0){
            result.setCode(AResultCode.IS_NULL);
        }else {
            if (password.equals(bean.getPassword())) {
                result.setCode(AResultCode.OK);
                result.setResult(bean);
            }else {
                result.setCode(AResultCode.FAIL);
            }
        }

        return result;
    }


}
