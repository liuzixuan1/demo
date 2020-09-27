package com.talkweb.demo.config;

/**
 * @author liuzixuan
 * @date 2020/9/20
 */
public class RatioConfig {

    /**
     * 根据成交价和卡片类型，得到对应的结算比例
     * @param end_price
     * @param card_type
     * @return ratio 结算比例
     */
    public static double getRatio(double end_price, String card_type) {
        double ratio = 0.0;
        if( 1 <= end_price && end_price < 50) {
            ratio = 0.1;
        } else if(50 <= end_price && end_price < 499.99) {
             ratio = 0.1;
        } else if(500 <= end_price && end_price < 999.99) {
             if ("非评级".equals(card_type)) {
                 ratio = 0.095;
             } else {
                 ratio = 0.09;
             }
        } else if(1000 <= end_price && end_price < 1999.99) {
             if ("非评级".equals(card_type)) {
                 ratio = 0.09;
             } else {
                 ratio = 0.085;
             }
        } else if(2000 <= end_price && end_price < 4999.99) {
             if ("非评级".equals(card_type)) {
                 ratio = 0.085;
             } else {
                 ratio = 0.08;
             }
        } else if(5000 <= end_price && end_price < 9999.99) {
             if ("非评级".equals(card_type)) {
                 ratio = 0.08;
             } else {
                 ratio = 0.075;
             }
        } else if(10000 <= end_price && end_price < 24999.99) {
             if ("非评级".equals(card_type)) {
                 ratio = 0.075;
             } else {
                 ratio = 0.07;
             }
        } else if(25000 <= end_price && end_price < 49999.99) {
             if ("非评级".equals(card_type)) {
                 ratio = 0.07;
             } else {
                 ratio = 0.065;
             }
        } else {
             if ("非评级".equals(card_type)) {
                 ratio = 0.065;
             } else {
                 ratio = 0.06;
             }
        }

        return ratio;
    }


}
