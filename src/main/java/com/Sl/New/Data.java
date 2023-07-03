package com.Sl.New;

import java.awt.*;
import java.io.File;
import java.util.Random;

public class Data {
    /*
    NAME 该对象的名字
    lord 所属人
    head 头像
    race 种族
    mood 当天心情
    loveGif 喜欢的礼物
    loveFood 喜欢的食物
    isTransfer 是否可以转让
    isWife 是否是人妻
    isNTR 是否喜欢被ntr
     */
    private String NAME;
    private String lord;
    private File head;
    private String race;
    private int mood;
    private int happiness;
    private final String loveGif;
    private final String loveFood;
    private final boolean isTransfer;
    private boolean isWife;
    private final boolean isNTR;
    public Data(String name,String lord){
        Random random =new Random();
        this.NAME=name;
        this.lord=lord;
        this.head=new File("");
        this.loveFood=NewData.getFoods();
        this.loveGif=NewData.getGifs();
        this.isTransfer=(10==random.nextInt(100));
        this.isNTR=(2222==random.nextInt(100000));
        this.happiness=random.nextInt(20);
    }

    public void setMood(int a) {
        mood +=a;
        if (mood<0)mood=0;
        if (mood>100)mood=100;
    }
}
