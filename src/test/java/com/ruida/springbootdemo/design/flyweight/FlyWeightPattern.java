package com.ruida.springbootdemo.design.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 共享资源 eg:String,Integer,Long...
 */
public class FlyWeightPattern {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(2,4,TreeFactory.getTree("xxx","xxxxxx"));
        TreeNode treeNode2 = new TreeNode(10,20,TreeFactory.getTree("xxx","xxxxxx"));

        TreeNode treeNode3 = new TreeNode(15,20,TreeFactory.getTree("yyy","yyyyyy"));
        TreeNode treeNode4 = new TreeNode(10,20,TreeFactory.getTree("yyy","yyyyyy"));
    }
}

class Tree{
    private final String name;

    private final String data;

    public Tree(String name, String data) {
        System.out.println(name+" tree,created...");
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }
}

class TreeNode{
    private int x;

    private int y;

    private Tree tree;

    public TreeNode(int x, int y, Tree tree) {
        this.x = x;
        this.y = y;
        this.tree = tree;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }
}

class TreeFactory{
    private static Map<String,Tree> map = new ConcurrentHashMap<>();

    public static Tree getTree(String name,String data){
        if(map.containsKey(name)){
            return map.get(name);
        }

        Tree tree = new Tree(name,data);
        map.put(name,tree);
        return tree;
    }
}
