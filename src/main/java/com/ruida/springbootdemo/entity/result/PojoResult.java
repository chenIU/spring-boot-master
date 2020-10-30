package com.ruida.springbootdemo.entity.result;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-30 15:08
 */
public class PojoResult<T> extends CommonResult {

    private static final long serialVersionUID = 4417025794008739420L;

    private T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
