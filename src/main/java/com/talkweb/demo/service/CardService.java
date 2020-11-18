package com.talkweb.demo.service;

import java.util.List;
import com.talkweb.pangu.base.common.pojo.PageBean;
import com.talkweb.pangu.base.common.result.AResultCode;
import com.talkweb.pangu.base.common.result.ResultMap;
import com.talkweb.demo.pojo.CardBean;

/**
 *<p>Title:CardService.java</p>
 *<p>Description:hellworldService</p>
 *@author zyh
 *@version 1.0
 *@Automatically generate by Coder in 2020-09-15 21:51
 */
public interface CardService{
    /**
     *<b>Summary: 保存数据</b>
     * insert
     * @param bean
     * @return
     */
    public ResultMap<AResultCode, CardBean> insert(CardBean bean);

    /**
     *<b>Summary: 更新数据</b>
     * update
     * @param bean
     * @return
     */
    public ResultMap<AResultCode, CardBean> update(CardBean bean);

    /**
     *<b>Summary: 删除数据</b>
     * delete
     * @param card_id
     * @return
     */
    public ResultMap<AResultCode, CardBean> delete(String card_id);

    /**
     *<b>Summary: 分页查询列表数据</b>
     * pageList
     * @param pb
     * @return
     */
    public ResultMap<AResultCode, PageBean<CardBean>> pageList(PageBean<CardBean> pb);

    /**
     *<b>Summary: 查询列表数据</b>
     * list
     * @param bean
     * @return
     */
    public ResultMap<AResultCode, List<CardBean>> list(CardBean bean);

    /**
     *<b>Summary: 根据Id查询数据</b>
     * get
     * @param card_id
     * @return
     */
    public ResultMap<AResultCode, CardBean> get(String card_id);

    /**
     *  修改多个卡片状态为  “已结算”
     * @param card_id
     * @return
     */
    public ResultMap<AResultCode, CardBean> commit(String card_id);

    public void saveCardList(List<CardBean> cardBeans);
}
