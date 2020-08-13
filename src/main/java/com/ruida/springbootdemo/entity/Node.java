package com.ruida.springbootdemo.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-08-12 15:55
 */
public class Node {
    private int id;
    private int pid;
    private String name;
    private List<Node> sub = new ArrayList<>();
    public Node(int id, int pid) {
        this.id = id;
        this.pid = pid;
    }

    public Node(int id, int pid, String name) {
        this(id, pid);
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getSub() {
        return sub;
    }

    public void setSub(List<Node> sub) {
        this.sub = sub;
    }
}