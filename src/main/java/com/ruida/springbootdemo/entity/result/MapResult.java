package com.ruida.springbootdemo.entity.result;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-30 13:40
 */
public class MapResult<K,V> extends CommonResult{

    private static final long serialVersionUID = -7421750379351307675L;

    private Map<K,V> content;

    public MapResult add(K key,V value){
        if(content  == null){
            setContent(new HashMap<>(16));
        }
        getContent().put(key,value);
        return this;
    }

    public Map<K, V> getContent() {
        return content;
    }

    public void setContent(Map<K, V> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MapResult{" +
                super.toString() +
                "content=" + content +
                '}';
    }
}
