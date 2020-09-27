package com.talkweb.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 *<p>Title:UCardBean.java</p>
 *<p>Description:hellworld Bean(对应表名:xb_card)</p>
 *@author zyh
 *@version 1.0
 *@Automatically generate by Coder in 2020-09-19 12:16
 */
public class UCardBean implements Serializable {
	private static final long serialVersionUID = 1L;
    private String card_id;		//卡片id
    private String card_name;		//卡片名称
    private String card_no;		//卡片编号
    private String card_type;		//卡片类型；非评级卡、评级卡（含原封贴）、其他类型
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",locale = "zh",timezone="GMT+8")
    private Date end_time;		//截标日期
    private double end_price;		//成交价
    private double pay_price;		//实付款项
    private String buyer_id;		//买家ID
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",locale = "zh",timezone="GMT+8")
    private Date pay_time;		//付款日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",locale = "zh",timezone="GMT+8")
    private Date send_time;		//发货日期
    private String waybill_number;		//运单号
    private double settlement_ratio;		//结算比例
    private String status;		//物品状态；1.待结算；2.已结算；3.顶回；4.未付款；5.取消或其他
    private String comments;		//备注

	/**
	*<b>Summary:设置卡片id</b>
	* setCard_id
	* @param card_id
	*/
    public void setCard_id(String card_id){
    	this.card_id = card_id;
    }
    /**
	*<b>Summary:获取卡片id</b>
	* getCard_id
	* @return
	*/
    public String getCard_id(){
    	return card_id;
    }
    
	/**
	*<b>Summary:设置卡片名称</b>
	* setCard_name
	* @param card_name
	*/
    public void setCard_name(String card_name){
    	this.card_name = card_name;
    }
    /**
	*<b>Summary:获取卡片名称</b>
	* getCard_name
	* @return
	*/
    public String getCard_name(){
    	return card_name;
    }
    
	/**
	*<b>Summary:设置卡片编号</b>
	* setCard_no
	* @param card_no
	*/
    public void setCard_no(String card_no){
    	this.card_no = card_no;
    }
    /**
	*<b>Summary:获取卡片编号</b>
	* getCard_no
	* @return
	*/
    public String getCard_no(){
    	return card_no;
    }
    
	/**
	*<b>Summary:设置卡片类型；非评级卡、评级卡（含原封贴）、其他类型</b>
	* setCard_type
	* @param card_type
	*/
    public void setCard_type(String card_type){
    	this.card_type = card_type;
    }
    /**
	*<b>Summary:获取卡片类型；非评级卡、评级卡（含原封贴）、其他类型</b>
	* getCard_type
	* @return
	*/
    public String getCard_type(){
    	return card_type;
    }
    
	/**
	*<b>Summary:设置截标日期</b>
	* setEnd_time
	* @param end_time
	*/
    public void setEnd_time(Date end_time){
    	this.end_time = end_time;
    }
    /**
	*<b>Summary:获取截标日期</b>
	* getEnd_time
	* @return
	*/
    public Date getEnd_time(){
    	return end_time;
    }
    
	/**
	*<b>Summary:设置成交价</b>
	* setEnd_price
	* @param end_price
	*/
    public void setEnd_price(double end_price){
    	this.end_price = end_price;
    }
    /**
	*<b>Summary:获取成交价</b>
	* getEnd_price
	* @return
	*/
    public double getEnd_price(){
    	return end_price;
    }
    
	/**
	*<b>Summary:设置实付款项</b>
	* setPay_price
	* @param pay_price
	*/
    public void setPay_price(double pay_price){
    	this.pay_price = pay_price;
    }
    /**
	*<b>Summary:获取实付款项</b>
	* getPay_price
	* @return
	*/
    public double getPay_price(){
    	return pay_price;
    }
    
	/**
	*<b>Summary:设置买家ID</b>
	* setBuyer_id
	* @param buyer_id
	*/
    public void setBuyer_id(String buyer_id){
    	this.buyer_id = buyer_id;
    }
    /**
	*<b>Summary:获取买家ID</b>
	* getBuyer_id
	* @return
	*/
    public String getBuyer_id(){
    	return buyer_id;
    }
    
	/**
	*<b>Summary:设置付款日期</b>
	* setPay_time
	* @param pay_time
	*/
    public void setPay_time(Date pay_time){
    	this.pay_time = pay_time;
    }
    /**
	*<b>Summary:获取付款日期</b>
	* getPay_time
	* @return
	*/
    public Date getPay_time(){
    	return pay_time;
    }
    
	/**
	*<b>Summary:设置发货日期</b>
	* setSend_time
	* @param send_time
	*/
    public void setSend_time(Date send_time){
    	this.send_time = send_time;
    }
    /**
	*<b>Summary:获取发货日期</b>
	* getSend_time
	* @return
	*/
    public Date getSend_time(){
    	return send_time;
    }
    
	/**
	*<b>Summary:设置运单号</b>
	* setWaybill_number
	* @param waybill_number
	*/
    public void setWaybill_number(String waybill_number){
    	this.waybill_number = waybill_number;
    }
    /**
	*<b>Summary:获取运单号</b>
	* getWaybill_number
	* @return
	*/
    public String getWaybill_number(){
    	return waybill_number;
    }
    
	/**
	*<b>Summary:设置结算比例</b>
	* setSettlement_ratio
	* @param settlement_ratio
	*/
    public void setSettlement_ratio(double settlement_ratio){
    	this.settlement_ratio = settlement_ratio;
    }
    /**
	*<b>Summary:获取结算比例</b>
	* getSettlement_ratio
	* @return
	*/
    public double getSettlement_ratio(){
    	return settlement_ratio;
    }
    
	/**
	*<b>Summary:设置物品状态；1.待结算；2.已结算；3.顶回；4.未付款；5.取消或其他</b>
	* setStatus
	* @param status
	*/
    public void setStatus(String status){
    	this.status = status;
    }
    /**
	*<b>Summary:获取物品状态；1.待结算；2.已结算；3.顶回；4.未付款；5.取消或其他</b>
	* getStatus
	* @return
	*/
    public String getStatus(){
    	return status;
    }
    
	/**
	*<b>Summary:设置备注</b>
	* setComments
	* @param comments
	*/
    public void setComments(String comments){
    	this.comments = comments;
    }
    /**
	*<b>Summary:获取备注</b>
	* getComments
	* @return
	*/
    public String getComments(){
    	return comments;
    }
    
}