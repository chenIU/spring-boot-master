package com.ruida.springbootdemo.entity.result;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-30 15:24
 */
public class PageResult<T> extends CommonResult{

    private static final long serialVersionUID = -7238706290017333347L;

    private Page<T> content;

    public Page<T> getContent() {
        return content;
    }

    public void setContent(Page<T> content) {
        this.content = content;
    }
}
