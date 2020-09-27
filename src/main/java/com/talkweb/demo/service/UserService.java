package com.talkweb.demo.service;

import com.talkweb.demo.pojo.UserBean;
import com.talkweb.pangu.base.common.pojo.PageBean;
import com.talkweb.pangu.base.common.result.AResultCode;
import com.talkweb.pangu.base.common.result.ResultMap;

import java.util.List;

/**
 * @author liuzixuan
 * @date 2020/9/13
 */
public interface UserService {
    /**
     *<b>Summary: 保存数据</b>
     * insert
     * @param bean
     * @return
     */
    public ResultMap<AResultCode, UserBean> insert(UserBean bean);

    /**
     *<b>Summary: 更新数据</b>
     * update
     * @param bean
     * @return
     */
    public ResultMap<AResultCode, UserBean> update(UserBean bean);

    /**
     *<b>Summary: 删除数据</b>
     * delete
     * @param user_id
     * @return
     */
    public ResultMap<AResultCode, UserBean> delete(String user_id);

    /**
     *<b>Summary: 分页查询列表数据</b>
     * pageList
     * @param pb
     * @return
     */
    public ResultMap<AResultCode, PageBean<UserBean>> pageList(PageBean<UserBean> pb);

    /**
     *<b>Summary: 查询列表数据</b>
     * list
     * @param bean
     * @return
     */
    public ResultMap<AResultCode, List<UserBean>> listAll(UserBean bean);

    /**
     *<b>Summary: 根据Id查询数据</b>
     * get
     * @param user_id
     * @return
     */
    public ResultMap<AResultCode, UserBean> get(String user_id);

    public ResultMap<AResultCode, UserBean> getLogin(String username, String password);
}
