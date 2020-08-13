package com.ruida.springbootdemo.utils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.ruida.springbootdemo.entity.Node;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-08-12 15:59
 */
public class TreeUtil {

    public static List<Node> buildTree(List<Node> nodes) {
        Map<Integer, List<Node>> sub = nodes.stream().filter(node -> node.getPid() != 0).collect(Collectors.groupingBy(Node::getPid));
        nodes.forEach(node -> node.setSub(sub.get(node.getId())));
        return nodes.stream().filter(node -> node.getPid() == 0).collect(Collectors.toList());
    }

    public static void main(String[] args) {
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
