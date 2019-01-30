package com.zb.dao;

import com.zb.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by bzheng on 2019/1/27.
 */
public interface UserDao extends BaseDao<User>{

    /**
     * 根据用户名查找信息
     * @param username
     * @return
     */
    User selectByUsername(@Param("username") String username);

    /**
     * 检查用户名唯一性
     *
     * @param username
     * @param id
     * @return
     */
    int selectCountByUsername(@Param("username") String username, @Param("excludeId") Integer id);
}
