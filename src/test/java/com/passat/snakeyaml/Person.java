package com.passat.snakeyaml;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by moooke on 2019/9/2.
 */
@Getter
@Setter
@ToString
public class Person {
    private String given;
    private String family;
    private Address address;
}