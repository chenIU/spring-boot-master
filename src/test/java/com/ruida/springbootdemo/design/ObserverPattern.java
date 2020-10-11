package com.ruida.springbootdemo.design;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Task1 task1 = new Task1();
        subject.addObserve(task1);
        Task2 task = new Task2();
        subject.addObserve(task);

        subject.notifyObserver("xxx");
        System.out.println("--------------");
        subject.remove(task1);
        subject.notifyObserver("yyy");
    }
}

class Subject{

    List<Observe> container = new ArrayList<>();

    public void addObserve(Observe observe){
        container.add(observe);
    }

    public void remove(Observe observe){
        container.remove(observe);
    }

    public void notifyObserver(Object obj){
        for(Observe observe:container){
            observe.update(obj);
        }
    }
}

interface Observe{
    void update(Object obj);
}

class Task1 implements Observe{

    @Override
    public void update(Object obj) {
        System.out.println("Task1 received: "+obj);
    }
}

class Task2 implements Observe{

    @Override
    public void update(Object obj) {
        System.out.println("Task2 received: "+obj);
    }
}
