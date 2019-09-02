package com.passat.snakeyaml;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by moooke on 2019/9/2.
 */
@Getter
@Setter
@ToString
public class Person2 {
    private String given;
    private String family;
    private List<Address> address;
}