package com.talkweb.demo.dao;

import com.talkweb.demo.pojo.UCardBean;
import com.talkweb.pangu.base.common.pojo.PageBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *<p>Title:UCardMapper.java</p>
 *<p>Description:hellworldDao</p>
 *@author zyh
 *@version 1.0
 *@Automatically generate by Coder in 2020-09-19 12:16
 */
@Mapper
 public interface UCardMapper {
	/**
    *<b>Summary: 选择性的保存数据</b>
    * insertSelective
    * @param bean
    */
	public void insertSelective(UCardBean bean);

	/**
    *<b>Summary: 选择性的更新数据</b>
    * updateSelective
    * @param bean
    */
	public void updateSelective(UCardBean bean);

	/**
    *<b>Summary: 选择性的更新数据</b>
    * delete
    * @param ids
    */
	public void updateSelective1(String[] ids);

	/**
    *<b>Summary: 分页查询数据</b>
    * pageList
    * @param pb
    * @return
    */
	public List<UCardBean> pageList(PageBean<UCardBean> pb);

	/**
    *<b>Summary: 普通查询</b>
    * list
    * @param bean
    */
	public List<UCardBean> list(UCardBean bean);

	/**
    *<b>Summary: 根据Id查询数据</b>
    * get
    * @param card_id
    */
	public UCardBean get(String card_id);

 }