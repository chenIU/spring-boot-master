package com.ruida.springbootdemo.enums;

/**
 * @description: 星期枚举
 * @author: chenjy
 * @create: 2020-03-27 15:39
 */
public enum WeekEum {

    Monday(1, "Mon", "星期一"),
    Tuesday(2, "Tue", "星期二"),
    Wednesday(3, "Wed", "星期三"),
    Thursay(4, "Thur", "星期四"),
    Friday(5, "Fri", "星期五"),
    Saturday(6, "Sat", "星期六"),
    Sunday(7, "Sun", "星期日");

    private int id;
    private String code;
    private String name;

    WeekEum(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getNameById(int id){
        WeekEum[] list = WeekEum.values();
        for(WeekEum one:list){
            if(one.getId()==id){
                return one.getName();
            }
        }
        return null;
    }

    public static String getCodeById(int id){
        WeekEum[] list = WeekEum.values();
        for(WeekEum one:list){
            if(one.getId()==id){
                return one.getCode();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getNameById(7));
        System.out.println(getCodeById(7));
    }

}
