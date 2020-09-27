package com.talkweb.demo.controller;

import com.talkweb.demo.pojo.UCardBean;
import com.talkweb.demo.service.UCardService;
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
 *<p>Title:UCardController.java</p>
 *<p>Description:hellworld Action</p>
 *@author zyh
 *@version 1.0
 *@Automatically generate by Coder in 2020-09-19 12:16
 */
@RestController
@RequestMapping(name="hellworld", value="/ucard/")
@Api(tags = {"hellworld Api 接口文档"})
public class UCardController {
	private static final Logger log = LoggerFactory.getLogger(UCardController.class);
	@Autowired
	private UCardService uCardService;

	@ApiOperation(value="新增接口")
	@CrossOrigin
	@RequestMapping(name="新增接口",value="insert.json",method = RequestMethod.POST)
	public ResultMap<AResultCode, UCardBean> insert(@ApiParam(value = "对象数据", required = true) @RequestBody UCardBean bean){
		return uCardService.insert(bean);
	}

	@ApiOperation(value="修改接口")
	@CrossOrigin
	@RequestMapping(name="修改接口",value="update.json",method = RequestMethod.POST)
	public ResultMap<AResultCode, UCardBean> update(@ApiParam(value = "对象数据", required = true) @RequestBody UCardBean bean){
		return uCardService.update(bean);
	}

	@ApiOperation(value="多修改接口")
	@ApiImplicitParam(name = "card_id", value = "主键ID", required = true, paramType = "query")
	@RequestMapping(name="多修改接口",value="updates.json",method = RequestMethod.GET)
	@CrossOrigin
	public ResultMap<AResultCode, UCardBean> updates(@RequestParam("card_id") String card_id){
		System.out.println(card_id);
		return uCardService.updateSelective1(card_id);
	}
	@CrossOrigin
	@ApiOperation(value="分页查询列表接口")
	@RequestMapping(name="分页查询列表接口",value="pageList.json",method = RequestMethod.POST)
	public ResultMap<AResultCode, PageBean<UCardBean>> pageList(@ApiParam(value = "分页对象数据", required = true) @RequestBody PageBean<UCardBean> pb){
		pb.init(pb,UCardBean.class);	//需要调用init，将页面传来的json条件转换为bean
		return uCardService.pageList(pb);
	}
	@CrossOrigin
	@ApiOperation(value="查询所有数据接口")
	@RequestMapping(name="查询所有数据接口",value="list.json",method = RequestMethod.POST)
	public ResultMap<AResultCode, List<UCardBean>> list(@ApiParam(value = "对象数据", required = true) @RequestBody(required = false) UCardBean bean){
		return uCardService.list(bean);
	}
	@CrossOrigin
	@ApiOperation(value="根据主键获取数据接口")
	@ApiImplicitParam(name = "card_id", value = "主键ID", required = true, paramType = "query")
	@RequestMapping(name="根据主键获取数据接口",value="get.json",method = RequestMethod.GET)
	public ResultMap<AResultCode, UCardBean> get(String card_id){
		return uCardService.get(card_id);
	}
	
}