package com.ruida.springbootdemo.utils;

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
}
