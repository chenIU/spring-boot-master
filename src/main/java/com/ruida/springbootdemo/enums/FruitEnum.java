package com.ruida.springbootdemo.enums;

public enum FruitEnum {
    APPLE(1,"apple"),
    BANANA(2,"banana"),
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
        System.out.println(FruitEnum.BANANA.ordinal());
        System.out.println(FruitEnum.APPLE.toString());

        for (FruitEnum value : FruitEnum.values()) {
            System.out.println(value.getId() + " " + value.getName());
        }

        System.out.println(FruitEnum.APPLE.compareTo(FruitEnum.BANANA));// -1

        System.out.println(FruitEnum.CHERRY.name());
    }

}
