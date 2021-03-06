package com.ruida.springbootdemo.entity;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-28 16:35
 */
public class App {
    private String appName;

    private String developer;

    private String companyName;

    public App(String appName, String developer, String companyName) {
        this.appName = appName;
        this.developer = developer;
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "App{" +
                "appName='" + appName + '\'' +
                ", developer='" + developer + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        App app = (App) o;

        if (appName != null ? !appName.equals(app.appName) : app.appName != null) return false;
        if (developer != null ? !developer.equals(app.developer) : app.developer != null) return false;
        return companyName != null ? companyName.equals(app.companyName) : app.companyName == null;
    }

    // 重写hashcode使用31的原因,31可以使用移位和减法来实现乘法运算,以获取更好的性能。31 * i = (i<<5) - i,现代VM都有这种优化
    @Override
    public int hashCode() {
        int result = appName != null ? appName.hashCode() : 0;
        result = 31 * result + (developer != null ? developer.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        return result;
    }
}
