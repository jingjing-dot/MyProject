package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

//    userId 考虑到之后功能，查询评论的时候不用userId,查询的时候的sql是动态的，有时用拼userId，有时不用
//    userId=0时，不查某特定用户的评论
//    offset是起始每页行号，limit是每页最多显示多少条数据
//    为了显示页码，要先查出表里一共有多少条数据，然后再/limit就行了
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

//    查询一共有多少条评论数
//    当函数只有一个参数，且这个参数是动态的，在<if>里拼的，那么就必须在这个参数前面加@Param注解，起个别名，不然会报错
    int selectDiscussPostRows(@Param("userId") int userId);

}
