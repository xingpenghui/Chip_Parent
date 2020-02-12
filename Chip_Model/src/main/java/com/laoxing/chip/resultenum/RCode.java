package com.laoxing.chip.resultenum;

/**
 * @program: Chip_Parent
 * @description: 枚举表达多种值
 * @author: Feri
 * @create: 2020-02-12 11:04
 */
public enum  RCode {
    SUCCESS(0),ERROR(1),NOTFOUND(404);
    private int val;
    private RCode(int v){
        val=v;
    }

    public int getVal() {
        return val;
    }}
