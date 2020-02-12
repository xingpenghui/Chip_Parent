package com.laoxing.chip.vo;

import com.laoxing.chip.resultenum.RCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: Chip_Parent
 * @description:
 * @author: Feri
 * @create: 2020-02-12 11:03
 */
@Data
public class R  implements Serializable {
    private int code;
    private String msg;
    private Object data;

    public static R setR(boolean issuccess,String msg,Object obj){
        R r=new R();
        if(issuccess){
            r.setCode(RCode.SUCCESS.getVal());
        }else {
            r.setCode(RCode.ERROR.getVal());
        }
        r.setMsg(msg);
        r.setData(obj);
        return r;
    }
    public static R ok(Object obj){
        return setR(true,"OK",obj);
    }
    public static R fail(){
        return setR(false,"ERROR",null);
    }

}
