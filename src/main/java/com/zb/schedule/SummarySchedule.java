package com.zb.schedule;

import com.zb.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by bzheng on 2019/1/13.
 * 定时任务--同步每天的账目汇总
 */
@Component
public class SummarySchedule {

    @Autowired
    SummaryService summaryService;

    /**
     * 每天同步汇总信息
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void createSummary() {
        summaryService.createSummary();
    }

}
