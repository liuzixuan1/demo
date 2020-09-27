package com.talkweb.demo.dao;

import com.talkweb.demo.pojo.CardBean;
import com.talkweb.pangu.base.common.pojo.PageBean;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 *<p>Title:CardMapper.java</p>
 *<p>Description:hellworldDao</p>
 *@author zyh
 *@version 1.0
 *@Automatically generate by Coder in 2020-09-15 21:51
 */
@Mapper
public interface CardMapper {
	/**
	 *<b>Summary: 选择性的保存数据</b>
	 * insertSelective
	 * @param bean
	 */
	public void insertSelective(CardBean bean);

	/**
	 *<b>Summary: 选择性的更新数据</b>
	 * updateSelective
	 * @param bean
	 */
	public void updateSelective(CardBean bean);

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
	public List<CardBean> pageList(PageBean<CardBean> pb);

	/**
	 *<b>Summary: 普通查询</b>
	 * list
	 * @param bean
	 */
	public List<CardBean> list(CardBean bean);

	/**
	 *<b>Summary: 根据Id查询数据</b>
	 * get
	 * @param card_id
	 */
	public CardBean get(String card_id);

}