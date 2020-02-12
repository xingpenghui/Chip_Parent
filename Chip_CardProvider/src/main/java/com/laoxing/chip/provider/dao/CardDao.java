package com.laoxing.chip.provider.dao;

import com.laoxing.chip.dto.CardDto;
import com.laoxing.chip.entity.Card;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: Chip_Parent
 * @description:
 * @author: Feri
 * @create: 2020-02-12 11:36
 */
public interface CardDao {
    //查询
    @Select("select * from t_card where phone=#{phone}")
    Card selectByPhone(String phone);
    //新增
    @Insert("insert into t_card(name,email,info,phone,address,position,blogurl,ctime,flag) values(#{name},#{email},#{info},#{phone},#{address},#{position},#{blogurl},now(),1)")
    int insert(CardDto dto);
    //查询全部
    @Select("select * from t_card order by ctime desc")
    List<Card> selectAll();
}
