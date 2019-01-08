package com.zb.dao;

import com.zb.entity.Task;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by bzheng on 2019/1/6.
 */
public interface TaskDao extends BaseDao<Task> {

    // 批量新增
    int insertList(@Param("list") List<Task> list);

    /**
     * 删除任务
     * @param businessId
     * @param dateTask
     * @return
     */
    @Delete("delete from t_task where business_id = #{businessId} and date_task = #{dateTask}")
    int deleteTasks(@Param("businessId") Integer businessId, @Param("dateTask") Date dateTask);
}
