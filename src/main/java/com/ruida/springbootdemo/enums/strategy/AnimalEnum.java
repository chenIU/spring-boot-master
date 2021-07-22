package com.ruida.springbootdemo.enums.strategy;

/**
 * @author Chen.J.Y
 * @date 2021/7/22
 * @desc
 */
public enum AnimalEnum implements Common {
    PANDA{
        @Override
        public String eat() {
            return "吃竹子";
        }
    },
    CAT{
        @Override
        public String eat() {
            return "吃鱼";
        }
    },
    MONKEY{
        @Override
        public String eat() {
            return "吃香蕉";
        }
    }
}
