package com.ruida.springbootdemo.entity.result;

import java.util.List;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-30 14:57
 */
public class ListResult<T> extends CommonResult {

    private static final long serialVersionUID = 8351887280963400840L;

    private List<T> content;

    private int totalCount;

    public ListResult(){

    }

    public ListResult(List<T> content){
        this.content = content;
        if(content != null){
            this.totalCount = content.size();
        }
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
        this.totalCount = content.size();
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
