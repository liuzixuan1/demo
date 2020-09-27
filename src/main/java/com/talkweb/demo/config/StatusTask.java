package com.talkweb.demo.config;

import com.talkweb.demo.dao.CardMapper;
import com.talkweb.demo.pojo.CardBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author liuzixuan
 * @date 2020/9/23
 */
@Service
public class StatusTask {

    @Autowired
    private CardMapper cardMapper;

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(1);
            }
        },new Date(System.currentTimeMillis()+20000));

        System.out.println(2);
    }



}
