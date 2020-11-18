package com.talkweb.demo.util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.talkweb.demo.pojo.CardBean;
import com.talkweb.demo.service.CardService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author liuzixuan
 * @date 2020/11/18
 */
public class ExcelListener extends AnalysisEventListener<CardBean> {

    private List<CardBean> list = new ArrayList<>();


    private CardService cardService;

    public ExcelListener(CardService cardService) {
        this.cardService = cardService;
    }

    /**
     * 每一条数据解析都会来调用
     * @param bean
     * @param analysisContext
     */
    @Override
    public void invoke(CardBean bean, AnalysisContext analysisContext) {
        System.out.println("解析到一条数据:========================"+bean.toString());
        // 数据存储到datas，供批量处理，或后续自己业务逻辑处理。
        list.add(bean);

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();//确保所有数据都能入库
        System.out.println("解析到" + list.size() + "数据");
        list.clear();
    }

    private void saveData() {
        cardService.saveCardList(list);
    }
}
