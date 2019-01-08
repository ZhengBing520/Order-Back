package com.zb.model;

import com.github.pagehelper.Page;
import com.zb.dto.BaseDto;
import com.zb.entity.BaseEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by bzheng on 2019/1/6.
 */
public class PageableData<S extends BaseDto> implements Serializable {

    /**
     * 总数
     */
    private Long totalCount;

    /**
     * 当前页数
     */
    private Integer currentPage;

    /**
     * 每页数量
     */
    private Integer pageSize;

    /**
     * 总页数
     */
    private Long totalPage;

    /**
     * 数据
     */
    private List<S> dataList;

    private PageableData() {
        dataList = new ArrayList<>();
    }

    public static <S extends BaseDto> PageableData<S> createModel() {
        return new PageableData<>();
    }

    /**
     * 通过普通分页参数直接构建一个PageableData对象
     *
     * @param totalCount
     * @param currentPage
     * @param pageSize
     * @param dataList
     * @param <S>
     * @return
     */
    public static <S extends BaseDto> PageableData<S> createModel(Long totalCount, Integer currentPage, Integer pageSize, List<S> dataList) {
        PageableData<S> newModel = createModel();
        if (pageSize == 0) {
            newModel.totalPage = 1L;
        } else {
            newModel.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        }
        newModel.pageSize = pageSize;
        newModel.totalCount = totalCount;
        newModel.currentPage = currentPage;
        newModel.dataList = dataList;
        return newModel;
    }


    /**
     * Entity 层的 Page 对象转换为PageableData
     *
     * @param page
     * @param dataList
     * @param <D>
     * @param <E>
     * @return
     */
    public static <D extends BaseDto, E extends BaseEntity> PageableData<D> createModel(Page<E> page, List<D> dataList) {
        PageableData<D> pageData = createModel();
        pageData.setCurrentPage(page.getPageNum());
        pageData.setTotalCount(page.getTotal());
        pageData.setPageSize(page.getPageSize());
//        pageData.setTotalPage(page.getTotal());
        pageData.setDataList(dataList);
        if (page.getPageSize() == 0) {
            pageData.setTotalPage(1L);
        } else {
            pageData.setTotalPage(page.getTotal() % page.getPageSize() == 0 ? page.getTotal() / page.getPageSize() : page.getTotal() / page.getPageSize() + 1);
        }
        return pageData;
    }

    /**
     * Entity 层的 Page 对象转换为PageableData
     *
     * @param page
     * @param dataList
     * @param <D>
     * @param <E>
     * @return
     */
    public static <D extends BaseDto, E extends Map> PageableData<D> createModelByMap(Page<E> page, List<D> dataList) {
        PageableData<D> pageData = createModel();
        pageData.setCurrentPage(page.getPageNum());
        pageData.setTotalCount(page.getTotal());
        pageData.setPageSize(page.getPageSize());
//        pageData.setTotalPage(page.getTotal());
        pageData.setDataList(dataList);
        if (page.getPageSize() == 0) {
            pageData.setTotalPage(1L);
        } else {
            pageData.setTotalPage(page.getTotal() % page.getPageSize() == 0 ? page.getTotal() / page.getPageSize() : page.getTotal() / page.getPageSize() + 1);
        }
        return pageData;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public List<S> getDataList() {
        return dataList;
    }

    public void setDataList(List<S> dataList) {
        this.dataList = dataList;
    }
}
