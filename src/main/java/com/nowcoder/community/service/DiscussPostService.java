package com.nowcoder.community.service;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

//    这个service层除了返回dao层的查询结果外，因为查询结果中有userId，但是在返回给页面时，不能只返回userId，要返回用户名，
//    有两种方法：1在mapper中写sql时，查的时候直接把用户名查出来，返回给service；2查到显示的数据之后，再根据userId查一遍用户名，跟discussPost组合起来返回给
    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit) {
        return discussPostMapper.selectDiscussPosts(userId, offset,limit);

    }

    public int findDiscussPostRows(int userId) {
        return discussPostMapper.selectDiscussPostRows(userId);
    }

}
