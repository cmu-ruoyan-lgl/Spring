package com.qdu.service.impl;

import com.qdu.mapper.TagMapper;
import com.qdu.pojo.Tag;
import com.qdu.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public int insertTags(List<Tag> tags) {
        return tagMapper.insertTags(tags);
    }
}
