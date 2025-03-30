package com.comefan.taggoodsweb.mapper;

import com.comefan.taggoodsweb.entity.TagEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TagMapper {
    List<TagEntity> queryTagList(@Param("id") Long id, @Param("name") String name);

    Integer insert(TagEntity tagEntity);

    Integer update(TagEntity tagEntity);

    TagEntity queryTagById(@Param("id") Long id);
}
