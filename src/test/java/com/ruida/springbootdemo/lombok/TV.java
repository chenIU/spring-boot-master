package com.ruida.springbootdemo.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: chenjy
 * @create: 2020-09-29 09:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TV {

    private int id;

    private String name;
}
