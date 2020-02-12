package com.laoxing.chip.provider.serviceimpl;

import com.laoxing.chip.dto.CardDto;
import com.laoxing.chip.entity.Card;
import com.laoxing.chip.provider.dao.CardDao;
import com.laoxing.chip.service.CardService;
import com.laoxing.chip.util.Base64Util;
import com.laoxing.chip.util.PhoneVcardUtil;
import com.laoxing.chip.vo.R;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: Chip_Parent
 * @description:
 * @author: Feri
 * @create: 2020-02-12 11:36
 */
@Component
@Service(version = "2.0.0")
public class CardServiceImpl implements CardService {
    //生成二维码的链接地址 参数需要进行base64url的编码
    private static String pre_url="http://localhost:9092//api/qrcode/cardqrcode.do?msg=";
    @Autowired
    private CardDao dao;

    @Override
    public R checkPhone(String phone) {
        Card card=dao.selectByPhone(phone);
        if(card!=null){
            //存在
            return R.fail();
        }else {
            //不存在
            return R.ok(null);
        }
    }

    @Override
    public R queryByPhone(String phone) {
        Card card=dao.selectByPhone(phone);
        if(card!=null){
            return R.ok(card);
        }else {
            return R.fail();
        }
    }

    @Override
    public R save(CardDto dto) {
        if(dto.getPhone()!=null && dao.selectByPhone(dto.getPhone())==null){
            //新增
            if(dao.insert(dto)>0){
                //成功就返回对应的二维码 路径
                String str= PhoneVcardUtil.createPV(dto);
                //base64url的编码
                String pcard= Base64Util.base64UrlEnc(str);
                return R.ok(pre_url+pcard);
            }else {
                return R.fail();
            }
        }else {
            return R.fail();
        }
    }

    @Override
    public R all() {
        return R.ok(dao.selectAll());
    }

    @Override
    public R queryQRcode(String phone) {
        Card card=dao.selectByPhone(phone);
        if(card!=null){
            //返回对应的二维码 链接
            return R.ok(pre_url+Base64Util.base64UrlEnc(PhoneVcardUtil.createPV(card)));
        }else {
            return R.fail();
        }
    }
}
