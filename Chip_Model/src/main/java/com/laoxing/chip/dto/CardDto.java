package com.laoxing.chip.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: Chip_Parent
 * @description:
 * @author: Feri
 * @create: 2020-02-12 11:01
 */
@Data
public class CardDto implements Serializable {
    private String name;
    private String info;
    private String phone;
    private String email;
    private String address;
    private String blogurl;
    private String position;

}
