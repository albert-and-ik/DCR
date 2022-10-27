package com.example.dcr.schedule;

import com.example.dcr.schedule.task.TaskSyncWithRubetek;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronExpression;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
@Slf4j
@AllArgsConstructor
public class SyncRubetekSchedule {

    final ThreadPoolTaskScheduler threadPoolTaskScheduler;
    final TaskSyncWithRubetek taskSyncWithRubetek;

    @Value("${app.rubetek.sync-cron}")
    String cronValue;


    @PostConstruct
    public void init() {
        threadPoolTaskScheduler.scheduleAtFixedRate(
                taskSyncWithRubetek,
                getDuration(cronValue)
        );
    }

    private static Duration getDuration(String cronValue) throws NullPointerException {

        CronExpression cronExpression = CronExpression.parse(cronValue);

        LocalDateTime next = cronExpression.next(LocalDateTime.now());

        if(next == null)
            throw new NullPointerException();

        LocalDateTime nextToNext = cronExpression.next(next);

        if(nextToNext == null)
            throw new NullPointerException();

        return Duration.between(
                next.toInstant(ZoneOffset.UTC),
                nextToNext.toInstant(ZoneOffset.UTC));

    }
}