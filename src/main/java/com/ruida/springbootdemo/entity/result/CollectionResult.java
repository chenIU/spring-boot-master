package com.ruida.springbootdemo.entity.result;

import java.util.Collection;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-30 15:05
 */
public class CollectionResult<T> extends CommonResult {

    private static final long serialVersionUID = -4597434954745668433L;

    private Collection<T> content;

    private int totalCount;

    public CollectionResult(){

    }

    public CollectionResult(Collection<T> content){
        this.content =  content;
        if(content != null){
            totalCount = content.size();
        }
    }

    public Collection<T> getContent() {
        return content;
    }

    public void setContent(Collection<T> content) {
        this.content = content;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
