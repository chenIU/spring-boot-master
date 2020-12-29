package com.ruida.springbootdemo.model;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-24 16:43
 */
public class PersonCountry {
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "PersonCountry{" +
                "country='" + country + '\'' +
                '}';
    }
}
