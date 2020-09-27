package com.talkweb.demo.service;

import com.talkweb.demo.pojo.UCardBean;
import com.talkweb.pangu.base.common.pojo.PageBean;
import com.talkweb.pangu.base.common.result.AResultCode;
import com.talkweb.pangu.base.common.result.ResultMap;

import java.util.List;

/**
 *<p>Title:UCardService.java</p>
 *<p>Description:hellworldService</p>
 *@author zyh
 *@version 1.0
 *@Automatically generate by Coder in 2020-09-19 12:16
 */
public interface UCardService {
    /**
	*<b>Summary: 保存数据</b>
	* insert
	* @param bean
	* @return
	*/
	public ResultMap<AResultCode, UCardBean> insert(UCardBean bean);

	/**
    *<b>Summary: 更新数据</b>
    * update
    * @param bean
	* @return
    */
	public ResultMap<AResultCode, UCardBean> update(UCardBean bean);

	/**
    *<b>Summary: 删除数据</b>
    * delete
    * @param card_id
	* @return
    */
	public ResultMap<AResultCode, UCardBean> updateSelective1(String card_id);

	/**
    *<b>Summary: 分页查询列表数据</b>
    * pageList
    * @param pb
	* @return
    */
	public ResultMap<AResultCode, PageBean<UCardBean>> pageList(PageBean<UCardBean> pb);

	/**
    *<b>Summary: 查询列表数据</b>
    * list
    * @param bean
	* @return
    */
	public ResultMap<AResultCode, List<UCardBean>> list(UCardBean bean);

	/**
    *<b>Summary: 根据Id查询数据</b>
    * get
    * @param card_id
	* @return
    */
	public ResultMap<AResultCode, UCardBean> get(String card_id);

}