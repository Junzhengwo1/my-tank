package com.kou.tank.enume;


/**
 * 坦克 枚举
 */

public enum TankEnum {

    SIZE_X(50,"宽50"),
    SIZE_Y(50,"高50");

    private final int size;
    private final String msg;

    TankEnum(int size, String msg) {
        this.size = size;
        this.msg = msg;
    }

    public int getSize() {
        return size;
    }

    public String getMsg() {
        return msg;
    }
}
