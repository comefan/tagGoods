package com.comefan.taggoodsweb.service;

import com.comefan.taggoodsweb.entity.TagEntity;
import com.comefan.taggoodsweb.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagMapper tagMapper;

    public List<TagEntity> queryTagList(Long id, String name){
        return tagMapper.queryTagList(id, name);
    }

    public Integer insert(TagEntity tagEntity){
        return tagMapper.insert(tagEntity);
    }
}
