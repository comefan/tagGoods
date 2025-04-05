package com.comefan.taggoodsweb.common.schedule;

import com.comefan.taggoodsweb.common.enums.TagStatusEnum;
import com.comefan.taggoodsweb.entity.TagEntity;
import com.comefan.taggoodsweb.service.TagMarkService;
import com.comefan.taggoodsweb.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Configuration
@EnableScheduling
@Slf4j
public class TagExpireSchedule {

    @Autowired
    private TagService tagService;

    @Autowired
    private TagMarkService tagMarkService;

    @Scheduled(cron = "0/5 * * * * ?")
    public void schedule(){
        log.info("TagExpireSchedule|schedule|执行定时任务");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<TagEntity> tagEntities = tagService.queryExpireTag(sdf.format(date));
//        log.info("TagExpireSchedule|schedule|查询到{}个过期标签", tagEntities.size());
        if(!CollectionUtils.isEmpty(tagEntities)){
            tagEntities.forEach(tagEntity -> {
                if (tagEntity.getCleanOnExpire() == 0){
                    tagEntity.setStatus(TagStatusEnum.EXPIRE.getCode());
                    tagService.update(tagEntity);
                    tagMarkService.deleteTagMarkByTagId(tagEntity.getId());
                }
            });
        }
    }
}
