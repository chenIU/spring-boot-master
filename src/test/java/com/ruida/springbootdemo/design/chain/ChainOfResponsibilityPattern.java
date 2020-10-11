package com.ruida.springbootdemo.design.chain;

public class ChainOfResponsibilityPattern {

    public static void main(String[] args) {
        Request request = new Request.RequestBuilder().frequentOk(true).login(false).build();

        RequestFrequentHandler requestFrequentHandler = new RequestFrequentHandler(new LoginHandler(null));

        if(requestFrequentHandler.process(request)){
            System.out.println("访问正常...");
        }else {
            System.out.println("访问异常...");
        }
    }
}


class Request{
    private boolean login;
    private boolean frequentOk;
    private boolean isPermit;
    private boolean containSensitiveWords;

    public Request(boolean login, boolean frequentOk, boolean isPermit, boolean containSensitiveWords) {
        this.login = login;
        this.frequentOk = frequentOk;
        this.isPermit = isPermit;
        this.containSensitiveWords = containSensitiveWords;
    }

    static class RequestBuilder{
        private boolean login;
        private boolean frequentOk;
        private boolean isPermit;
        private boolean containSensitiveWords;

        RequestBuilder login(boolean login){
            this.login = login;
            return this;
        }

        RequestBuilder frequentOk(boolean frequentOk){
            this.frequentOk = frequentOk;
            return this;
        }

        RequestBuilder isPermit(boolean isPermit){
            this.isPermit = isPermit;
            return this;
        }

        RequestBuilder containSensitiveWords(boolean containSensitiveWords){
            this.containSensitiveWords = containSensitiveWords;
            return this;
        }

        public Request build(){
            Request request = new Request(login, frequentOk, isPermit, containSensitiveWords);
            return request;
        }
    }

    public boolean isLogin() {
        return login;
    }

    public boolean isFrequentOk() {
        return frequentOk;
    }

    public boolean isPermit() {
        return isPermit;
    }

    public boolean isContainSensitiveWords() {
        return containSensitiveWords;
    }
}

abstract class Handler{
    Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    abstract boolean process(Request request);
}

class RequestFrequentHandler extends Handler{

    public RequestFrequentHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("访问频率控制...");
        if(request.isFrequentOk()){
            Handler next = getNext();
            if(null == next){
                return true;
            }

            if(!next.process(request)){
                return false;
            }else {
                return true;
            }
        }
        return false;
    }
}

class LoginHandler extends Handler{

    public LoginHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("登录验证...");
        if(request.isLogin()){
            Handler next = getNext();
            if(null == next){
                return true;
            }
            if(!next.process(request)){
                return false;
            }else {
                return true;
            }
        }
        return false;
    }
}