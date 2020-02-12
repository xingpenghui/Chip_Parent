package com.laoxing.chip.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: Chip_Parent
 * @description: 对应的数据库的表 t_card
 * @author: Feri
 * @create: 2020-02-12 10:59
 */
@Data
public class Card implements Serializable {
    private Integer id;
    private String name;
    private String info;
    private String phone;
    private String email;
    private String address;
    private String blogurl;
    private String position;
    private int flag;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ctime;
}
