package com.ruida.springbootdemo.design;

public class FacadePattern {

    public static void main(String[] args) {
        Client1 client1 = new Client1();
        client1.doSomething();
        Client2 client2 = new Client2();
        client2.doSomething();
    }
}


class Client1{
    SubSystem1 subSystem1 = new SubSystem1();
    SubSystem2 subSystem2 = new SubSystem2();
    SubSystem3 subSystem3 = new SubSystem3();

    public void doSomething(){
        subSystem1.method1();
        subSystem2.method1();
        subSystem3.method1();
    }
}

class Facade{
    SubSystem1 subSystem1 = new SubSystem1();
    SubSystem2 subSystem2 = new SubSystem2();
    SubSystem3 subSystem3 = new SubSystem3();

    public void doSomethingFacade(){
        subSystem1.method1();
        subSystem2.method1();
        subSystem3.method1();
    }
}

class Client2{
    Facade facade = new Facade();

    public void doSomething(){
        facade.doSomethingFacade();
    }
}



class SubSystem1{
    public void method1(){
        System.out.println("SubSystem1 method1 executed...");
    }
}

class SubSystem2{
    public void method1(){
        System.out.println("SubSystem2 method1 executed...");
    }
}

class SubSystem3{
    public void method1(){
        System.out.println("SubSystem3 method1 executed...");
    }
}
