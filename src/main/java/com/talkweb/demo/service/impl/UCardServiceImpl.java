package com.talkweb.demo.service.impl;

import com.talkweb.demo.dao.UCardMapper;
import com.talkweb.demo.pojo.UCardBean;
import com.talkweb.demo.service.UCardService;
import com.talkweb.pangu.base.common.pojo.PageBean;
import com.talkweb.pangu.base.common.result.AResultCode;
import com.talkweb.pangu.base.common.result.ResultMap;
import com.talkweb.pangu.base.common.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *<p>Title:UCardServiceImpl.java</p>
 *<p>Description:hellworldServiceImpl</p>
 *@author zyh
 *@version 1.0
 *@Automatically generate by Coder in 2020-09-19 12:16
 */
@Service
public class UCardServiceImpl implements UCardService{
	private static final Logger log = LoggerFactory.getLogger(UCardServiceImpl.class);
	@Autowired
	private UCardMapper uCardMapper;
	
	@Override
	public ResultMap<AResultCode, UCardBean> insert(UCardBean bean){
		ResultMap<AResultCode, UCardBean> result = new ResultMap<AResultCode, UCardBean>();
		if(StringUtil.isNull(bean)){
			result.setCode(AResultCode.IS_NULL);
		} else {
			if(StringUtil.isNull(bean.getCard_id())){
				bean.setCard_id(StringUtil.getUUID());
			}
			uCardMapper.insertSelective(bean);	
			result.setCode(AResultCode.OK);
			result.setResult(bean);
		}
		return result;
	}

	
	@Override
	public ResultMap<AResultCode, UCardBean> update(UCardBean bean){
		ResultMap<AResultCode, UCardBean> result = new ResultMap<AResultCode, UCardBean>();

		if(StringUtil.isNull(bean)){
			result.setCode(AResultCode.IS_NULL);
		} else if(StringUtil.isNull(bean.getCard_id())){
			result.setCode(AResultCode.MISS_ID);
		} else {
			uCardMapper.updateSelective(bean);	
			result.setCode(AResultCode.OK);
			result.setResult(bean);
		}

		return result;
	}

	
	@Override
	public ResultMap<AResultCode, UCardBean> updateSelective1(String card_id){
		ResultMap<AResultCode, UCardBean> result = new ResultMap<AResultCode, UCardBean>();

		if(StringUtil.isNull(card_id)){
			result.setCode(AResultCode.MISS_ID);
		} else {
			String[] ids = card_id.split(",");
			uCardMapper.updateSelective1(ids);
			result.setCode(AResultCode.OK);
		}

		return result;
	}

	
	@Override
	public ResultMap<AResultCode, PageBean<UCardBean>> pageList(PageBean<UCardBean> pb){
		ResultMap<AResultCode, PageBean<UCardBean>> result = new ResultMap<AResultCode, PageBean<UCardBean>>();

		pb.setData(uCardMapper.pageList(pb));
		pb.clear();

		result.setCode(AResultCode.OK);
		result.setResult(pb);

		return result;
	}

	
	@Override
	public ResultMap<AResultCode, List<UCardBean>> list(UCardBean bean){
		ResultMap<AResultCode, List<UCardBean>> result = new ResultMap<AResultCode, List<UCardBean>>();

		List<UCardBean> list = uCardMapper.list(bean);
		result.setCode(AResultCode.OK);
		result.setResult(list);

		return result;
	}

	
	@Override
	public ResultMap<AResultCode, UCardBean> get(String card_id){
		ResultMap<AResultCode, UCardBean> result = new ResultMap<AResultCode, UCardBean>();
		if(StringUtil.isNull(card_id)){
			result.setCode(AResultCode.MISS_ID);
		} else {
			UCardBean bean = uCardMapper.get(card_id);
			if(bean != null) {
				result.setCode(AResultCode.OK);
				result.setResult(bean);
			} else {
				result.setCode(AResultCode.UNEXIST);
	 		}
		}
		return result;
	}

	
}