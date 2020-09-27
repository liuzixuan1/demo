package com.talkweb.demo.controller;

import com.talkweb.demo.pojo.CardBean;
import com.talkweb.demo.service.CardService;
import com.talkweb.pangu.base.common.pojo.PageBean;
import com.talkweb.pangu.base.common.result.AResultCode;
import com.talkweb.pangu.base.common.result.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;



/**
 *<p>Title:CardController.java</p>
 *<p>Description:hellworld Action</p>
 *@author zyh
 *@version 1.0
 *@Automatically generate by Coder in 2020-09-15 21:51
 */
@RestController
@RequestMapping(name="hellworld", value="/card")
@Api(tags = {"hellworld Api 接口文档"})
public class CardController {
	private static final Logger log = LoggerFactory.getLogger(CardController.class);
	@Autowired
	private CardService cardService;

	@ApiOperation(value="新增接口")
	@CrossOrigin
	@RequestMapping(name="新增接口",value="show.json",method = RequestMethod.GET)
	public String show(){
		return "cardService.insert(bean)";
	}

	@ApiOperation(value="新增接口")
	@CrossOrigin
	@RequestMapping(name="新增接口",value="insert.json",method = RequestMethod.POST)
	public ResultMap<AResultCode, CardBean> insert(@ApiParam(value = "对象数据", required = true) @RequestBody CardBean bean){
		return cardService.insert(bean);
	}

	@ApiOperation(value="修改接口")
	@CrossOrigin
	@RequestMapping(name="修改接口",value="update.json",method = RequestMethod.POST)
	public ResultMap<AResultCode, CardBean> update(@ApiParam(value = "对象数据", required = true) @RequestBody CardBean bean){
		return cardService.update(bean);
	}

	@ApiOperation(value="删除接口")
	@ApiImplicitParam(name = "card_id", value = "主键ID", required = true, paramType = "query")
	@RequestMapping(name="删除接口",value="delete.json",method = RequestMethod.GET)
	@CrossOrigin
	public ResultMap<AResultCode, CardBean> delete(@RequestParam("card_id") String card_id){
		return cardService.delete(card_id);
	}

	@ApiOperation(value="分页查询列表接口")
	@CrossOrigin
	@RequestMapping(name="分页查询列表接口",value="pageList.json",method = RequestMethod.POST)
	public ResultMap<AResultCode, PageBean<CardBean>> pageList(@ApiParam(value = "分页对象数据", required = true) @RequestBody PageBean<CardBean> pb){
		pb.init(pb,CardBean.class);	//需要调用init，将页面传来的json条件转换为bean
		return cardService.pageList(pb);
	}

	@ApiOperation(value="查询所有数据接口")
	@CrossOrigin
	@RequestMapping(name="查询所有数据接口",value="list.json",method = RequestMethod.POST)
	public ResultMap<AResultCode, List<CardBean>> list(@ApiParam(value = "对象数据", required = true) @RequestBody(required = false) CardBean bean){
		return cardService.list(bean);
	}

	@ApiOperation(value="根据主键获取数据接口")
	@ApiImplicitParam(name = "card_id", value = "主键ID", required = true, paramType = "query")
	@CrossOrigin
	@RequestMapping(name="根据主键获取数据接口",value="get.json",method = RequestMethod.GET)
	public ResultMap<AResultCode, CardBean> get(String card_id){
		return cardService.get(card_id);
	}
	
}