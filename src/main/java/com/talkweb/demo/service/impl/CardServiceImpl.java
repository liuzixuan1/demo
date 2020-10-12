package com.talkweb.demo.service.impl;

import com.talkweb.demo.config.RatioConfig;
import com.talkweb.demo.dao.CardMapper;
import com.talkweb.demo.pojo.CardBean;
import com.talkweb.demo.service.CardService;
import com.talkweb.pangu.base.common.pojo.PageBean;
import com.talkweb.pangu.base.common.result.AResultCode;
import com.talkweb.pangu.base.common.result.ResultMap;
import com.talkweb.pangu.base.common.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *<p>Title:CardServiceImpl.java</p>
 *<p>Description:hellworldServiceImpl</p>
 *@version 1.0
 *@Automatically generate by Coder in 2020-09-15 21:51
 */
@Service
public class CardServiceImpl implements CardService{
    private static final Logger log = LoggerFactory.getLogger(CardServiceImpl.class);
    @Autowired
    private CardMapper cardMapper;

    @Override
    public ResultMap<AResultCode, CardBean> insert(CardBean bean){
        ResultMap<AResultCode, CardBean> result = new ResultMap<AResultCode, CardBean>();
        if(StringUtil.isNull(bean)){
            result.setCode(AResultCode.IS_NULL);
        } else {
            if(StringUtil.isNull(bean.getCard_id())){
                bean.setCard_id(StringUtil.getUUID());
            }
            if (bean.getEnd_price()==0) {
                bean.setSettlement_ratio(0);
            } else {
                //根据成交价和卡片类型，生成对应的结算比例
                bean.setSettlement_ratio(RatioConfig.getRatio(bean.getEnd_price(), bean.getCard_type()));
            }
            cardMapper.insertSelective(bean);
            result.setCode(AResultCode.OK);
            result.setResult(bean);
        }
        return result;
    }


    @Override
    public ResultMap<AResultCode, CardBean> update(CardBean bean){
        ResultMap<AResultCode, CardBean> result = new ResultMap<AResultCode, CardBean>();
        String status = bean.getStatus();
        if(StringUtil.isNull(bean)){
            result.setCode(AResultCode.IS_NULL);
        } else if(StringUtil.isNull(bean.getCard_id())){
            result.setCode(AResultCode.MISS_ID);
        } else {
            if ("已付款".equals(bean.getStatus()) && "评级卡".equals(bean.getCard_type())) {
                //  当评级卡状态改变为：已付款时，直接执行定时任务
                task(bean);
            }
            if (bean.getWaybill_number()!=null && "已付款".equals(bean.getStatus()) == false) {
                //判断运单号是否为空

                //当输入运单号后，执行定时任务，改变卡片状态
                task(bean);
            }
            bean.setStatus(status);
            cardMapper.updateSelective(bean);
            result.setCode(AResultCode.OK);
            result.setResult(bean);
        }

        return result;
    }


    @Override
    public ResultMap<AResultCode, CardBean> delete(String card_id){
        ResultMap<AResultCode, CardBean> result = new ResultMap<AResultCode, CardBean>();

        if(StringUtil.isNull(card_id)){
            result.setCode(AResultCode.MISS_ID);
        } else {
            String[] ids = card_id.split(",");
            cardMapper.delete(ids);
            result.setCode(AResultCode.OK);
        }

        return result;
    }


    @Override
    public ResultMap<AResultCode, PageBean<CardBean>> pageList(PageBean<CardBean> pb){
        ResultMap<AResultCode, PageBean<CardBean>> result = new ResultMap<AResultCode, PageBean<CardBean>>();

        pb.setData(cardMapper.pageList(pb));
        pb.clear();

        result.setCode(AResultCode.OK);
        result.setResult(pb);

        return result;
    }


    @Override
    public ResultMap<AResultCode, List<CardBean>> list(CardBean bean){
        ResultMap<AResultCode, List<CardBean>> result = new ResultMap<AResultCode, List<CardBean>>();

        List<CardBean> list = cardMapper.list(bean);
        result.setCode(AResultCode.OK);
        result.setResult(list);

        return result;
    }


    @Override
    public ResultMap<AResultCode, CardBean> get(String card_id){
        ResultMap<AResultCode, CardBean> result = new ResultMap<AResultCode, CardBean>();
        if(StringUtil.isNull(card_id)){
            result.setCode(AResultCode.MISS_ID);
        } else {
            CardBean bean = cardMapper.get(card_id);
            if(bean != null) {
                result.setCode(AResultCode.OK);
                result.setResult(bean);
            } else {
                result.setCode(AResultCode.UNEXIST);
            }
        }
        return result;
    }

    /**
     * 根据卡片类型，定时更改卡片状态为待结算
     * @param bean
     */
    public void task(CardBean bean) {
        bean.setStatus("待结算");
        if ("评级".equals(bean.getCard_type())) {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    cardMapper.updateSelective(bean);
                }
            },new Date(System.currentTimeMillis()+86400));
        } else {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    cardMapper.updateSelective(bean);
                }
            },new Date(System.currentTimeMillis()+172800));
        }
    }


}