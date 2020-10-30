package com.ruida.springbootdemo.entity.result;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-30 15:15
 */
public class Page<T> implements Serializable {

    private static final long serialVersionUID = 639857840826268558L;

    private int total;

    private int currentPage;

    private int pageSize;

    private int totalPage;

    private List<T> result;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "GMT+8")
    private Date nowTime;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        if(pageSize ==0 || total ==0){
            return 0;
        }
        totalPage = total % pageSize == 0 ? (total/pageSize) : (total/pageSize) + 1;
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getResult() {
        if(result == null){
            result = new ArrayList<>();
        }
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public Date getNowTime() {
        return nowTime;
    }

    public void setNowTime(Date nowTime) {
        this.nowTime = nowTime;
    }

    public int getOffset(){
        return (currentPage -1) * pageSize;
    }
}
