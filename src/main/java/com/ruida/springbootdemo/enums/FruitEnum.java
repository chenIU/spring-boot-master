package com.ruida.springbootdemo.enums;

public enum FruitEnum {
    APPLE(1,"apple"),
    BNANA(2,"bnana"),
    CHERRY(3,"cherry");

    private int id;

    private String name;

    FruitEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * 根据id查找名称
     * @param id
     * @return
     */
    public static String getNameById(int id){
        FruitEnum [] arr = FruitEnum.values();
        for(FruitEnum fe:arr){
            if(fe.getId()==id){
                return fe.getName();
            }
        }
        return "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        System.out.println(getNameById(2));
    }

}
