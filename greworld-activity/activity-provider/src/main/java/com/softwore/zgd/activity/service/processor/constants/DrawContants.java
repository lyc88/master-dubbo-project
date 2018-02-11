package com.softwore.zgd.activity.service.processor.constants;

/**
 * @author 风骚的GRE
 * @Description TODO
 * @date 2018/1/30.
 */
public class DrawContants {
    public final static String DRAW_ITEM="DRAW:ITEM"; //抽奖奖项的所有item key
    public final static String DRAW_AWARD="DRAW:AWARD:"; //奖项对应的奖品key
    public final static String DRAWING_PREFIX="DRAWING:"; //正在抽奖的redis key前缀
    public final static int EXPIRE_TIME=10; //整个活动的所有key的过期时间，10天

    public enum ISEXIST{
        UNEXIST("0"), EXIST("1");
        private String value;
        ISEXIST(String value){
            this.value=value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum AWARD_TYPE_ENUM{
        JD_CARD(1),FINANCE(2),NONE(3);
        private int value;
        AWARD_TYPE_ENUM(int value){this.value=value;}
        public int getValue(){return value;}
    }
}
