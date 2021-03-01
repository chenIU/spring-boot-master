package com.ruida.springbootdemo.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.ruida.springbootdemo.entity.Node;
import com.ruida.springbootdemo.utils.TreeUtil;
import org.junit.Test;

import java.util.List;

/**
 * @author chenjy
 * @since 2021/3/1 16:01
 */
public class TestBuildTree {

    @Test
    public void test(){
        Node dennis = new Node(1, 0, "dennis");
        Node calm = new Node(2, 0, "calm");
        Node daughter = new Node(3, 1, "daughter");
        Node grandson = new Node(4, 3, "grandson");
        Node son = new Node(5, 2, "son");
        List<Node> nodes = Lists.newArrayList(dennis, calm, daughter, son, grandson);
        List<Node> tree = TreeUtil.buildTree(nodes);
        System.out.println(JSON.toJSONString(tree));
    }
}
