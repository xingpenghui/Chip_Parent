package com.laoxing.chip.util;

import com.laoxing.chip.dto.CardDto;
import com.laoxing.chip.entity.Card;

/**
 * @program: Chip_Parent
 * @description:
 * @author: Feri
 * @create: 2020-02-12 15:53
 */
public class PhoneVcardUtil {

    /**
     * 手机联系人的固定格式*/
    public static String createPV(CardDto dto){
        StringBuffer buffer=new StringBuffer();
        buffer.append("BEGIN:VCARD\n");
        buffer.append("NOTE:"+dto.getInfo()+"\n");
        buffer.append("N:"+dto.getName()+"\n");
        buffer.append("TITLE:"+dto.getPosition()+"\n");
        buffer.append("ADR:"+dto.getAddress()+"\n");
        buffer.append("EMAIL:"+dto.getEmail()+"\n");
        buffer.append("TEL:"+dto.getPhone()+"\n");
        buffer.append("URL:"+dto.getBlogurl()+"\n");
        buffer.append("END:VCARD\n");
        return buffer.toString();
    }
    /**
     * 手机联系人的固定格式*/
    public static String createPV(Card card){
        StringBuffer buffer=new StringBuffer();
        buffer.append("BEGIN:VCARD\n");
        buffer.append("NOTE:"+card.getInfo()+"\n");
        buffer.append("N:"+card.getName()+"\n");
        buffer.append("TITLE:"+card.getPosition()+"\n");
        buffer.append("ADR:"+card.getAddress()+"\n");
        buffer.append("EMAIL:"+card.getEmail()+"\n");
        buffer.append("TEL:"+card.getPhone()+"\n");
        buffer.append("URL:"+card.getBlogurl()+"\n");
        buffer.append("END:VCARD\n");
        return buffer.toString();
    }
}
