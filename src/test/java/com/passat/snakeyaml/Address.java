package com.passat.snakeyaml;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by moooke on 2019/9/2.
 * 通过引入lombok省去getter setter等代码
 */
@Setter
@Getter
@ToString
public class Address {
    private String lines;
    private String city;
    private String state;
    private Integer postal;
}
