package com.laoxing.chip.exception;

/**
 * @program: Chip_Parent
 * @description: 自定义异常
 * @author: Feri
 * @create: 2020-02-12 11:02
 */
public class CardException extends Exception {
    public CardException(){
        super();
    }
    public CardException(String msg){
        super(msg);
    }

}
