package com.laoxing.chip.service;

import com.laoxing.chip.dto.CardDto;
import com.laoxing.chip.vo.R;

/**
 * @program: Chip_Parent
 * @description:
 * @author: Feri
 * @create: 2020-02-12 11:06
 */
public interface CardService {
    /**
     * ​	1.校验手机号是否存在
     *
     * ​	2.根据手机号查询名片
     *
     * ​	3.新增名片信息
     *
     * ​	4.查询名片列表*/
    R checkPhone(String phone);
    R queryByPhone(String phone);
    R save(CardDto dto);
    R all();

    //查询 名片对应的二维码
    R queryQRcode(String phone);
}
