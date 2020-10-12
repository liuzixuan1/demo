package com.talkweb.demo.controller;

import com.talkweb.demo.pojo.CardBean;
import com.talkweb.demo.pojo.UserBean;
import com.talkweb.demo.service.UserService;
import com.talkweb.pangu.base.common.pojo.PageBean;
import com.talkweb.pangu.base.common.result.AResultCode;
import com.talkweb.pangu.base.common.result.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liuzixuan
 * @date 2020/9/13
 */
@RestController
@RequestMapping(name="公司信息表",value = "/user")
@Api(tags = {"企业表 Api 接口文档"})
public class UserController {
    @Autowired
    private UserService userService;


    @ApiOperation(value="新增接口")
    @CrossOrigin
    @RequestMapping(name="新增接口",value="insert.json",method = RequestMethod.POST)
    public ResultMap<AResultCode, UserBean> insert(@ApiParam(value = "对象数据", required = true) @RequestBody UserBean bean){
        return userService.insert(bean);
    }
    @CrossOrigin
    @ApiOperation(value="修改接口")
    @RequestMapping(name="修改接口",value="update.json",method = RequestMethod.POST)
    public ResultMap<AResultCode, UserBean> update(@ApiParam(value = "对象数据", required = true) @RequestBody UserBean bean){
        return userService.update(bean);
    }

    @CrossOrigin
    @ApiOperation(value="删除接口")
    @ApiImplicitParam(name = "user_id", value = "主键ID", required = true, paramType = "query")
    @RequestMapping(name="删除接口",value="delete.json",method = RequestMethod.GET)
    public ResultMap<AResultCode, UserBean> delete(@RequestParam("user_id") String user_id){
        return userService.delete(user_id);
    }

    @CrossOrigin
    @ApiOperation(value="分页查询列表接口")
    @RequestMapping(name="分页查询列表接口",value="pageList.json",method = RequestMethod.POST)
    public ResultMap<AResultCode, PageBean<UserBean>> pageList(@ApiParam(value = "分页对象数据", required = true) @RequestBody PageBean<UserBean> pb){

        pb.init(pb,UserBean.class);	//需要调用init，将页面传来的json条件转换为bean
        return userService.pageList(pb);
    }

    @CrossOrigin
    @ApiOperation(value="查询所有数据接口")
    @RequestMapping(name="查询所有数据接口",value="list.json",method = RequestMethod.POST)
    public ResultMap<AResultCode, List<UserBean>> list(@ApiParam(value = "对象数据", required = true) @RequestBody(required = false) UserBean bean){
        return userService.listAll(bean);
    }

    @CrossOrigin
    @ApiOperation(value="根据主键获取数据接口")
    @RequestMapping(name="根据主键获取数据接口",value="get.json",method = RequestMethod.GET)
    public ResultMap<AResultCode, UserBean> get(@RequestParam("user_id") String user_id){
        return userService.get(user_id);
    }

    @CrossOrigin
    @ApiOperation(value="管理员登录")
    @RequestMapping(name="管理员登录",value="loginA.json",method = RequestMethod.GET)
    public ResultMap<AResultCode, UserBean> loginA(@RequestParam("username")  String username, @RequestParam("password") String password){
        int status = 0;
        return userService.getLogin(username, password,status);

    }

    @CrossOrigin
    @ApiOperation(value="用户登录")
    @RequestMapping(name="用户登录",value="loginU.json",method = RequestMethod.GET)
    public ResultMap<AResultCode, UserBean> loginU(@RequestParam("username")  String username, @RequestParam("password") String password){
        int status = 1;
        return userService.getLogin(username, password,status);
    }




}
