package com.talkweb.demo.dao;

import com.talkweb.demo.pojo.UserBean;
import com.talkweb.pangu.base.common.pojo.PageBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author liuzixuan
 * @date 2020/9/13
 */
@Mapper
public interface UserMapper {

    /**
     *<b>Summary: 选择性的保存数据</b>
     * insertSelective
     * @param bean
     */
    public void insertSelective(UserBean bean);

    /**
     *<b>Summary: 选择性的更新数据</b>
     * updateSelective
     * @param bean
     */
    public void updateSelective(UserBean bean);

    /**
     *<b>Summary: 删除数据</b>
     * delete
     * @param ids
     */
    public void delete(String[] ids);

    /**
     *<b>Summary: 分页查询数据</b>
     * pageList
     * @param pb
     * @return
     */
    public List<UserBean> pageList(PageBean<UserBean> pb);

    /**
     *<b>Summary: 普通查询</b>
     * list
     * @param bean
     */
    public List<UserBean> listAll(UserBean bean);

    /**
     *<b>Summary: 根据Id查询数据</b>
     * get
     * @param user_id
     */
    public UserBean get(String user_id);

    public int countUser(String username);

    public UserBean getLogin(String username);

}
