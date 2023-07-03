package com.Sl.New;

import java.util.Random;
public class DailyEvent {
    String info;
    public void event1(Data person) {
        info="摔倒了";
        person.setMood(-5 - new Random().nextInt(5));
    }
    public void event2(Data person) {
        info="感冒了";
        person.setMood(-10 - new Random().nextInt(7));
    }
    public void event3(Data person) {
        info ="起床抽筋";
        person.setMood(-12-new Random().nextInt(15));
    }
    public void event4(Data person){
        info="喝水呛到";
        person.setMood(-5 - new Random().nextInt(5));
    }
    public void event5(Data person){
        info="喝水,烫到舌头";
        person.setMood(-2-new Random().nextInt(5));
    }
    public void event6(Data person){
        info="新增bug";
        person.setMood(-50);
    }
    public void event7(Data person){
        info="被老板臭骂";
        person.setMood(-99);
    }
    public void event8(Data person){
        info="被铸币搭讪";
        person.setMood(-5-new Random().nextInt(4));
    }
    public void event9(Data person){
        info="被帅哥搭讪";
        person.setMood(+10+new Random().nextInt(5));
    }
    public void event10(Data person){
        info="遇到熟人";
        person.setMood(+5+new Random().nextInt(10));
    }
    public void event11(Data person){
        info="走路玩手机，撞到电线杆";
        person.setMood(-2-new Random().nextInt(3));
    }
    public void event12(Data person){
        info="解决一个bug";
        person.setMood(+100);
    }
    public void event13(Data person){
        info="喝了一杯巨好喝的奶茶";
        person.setMood(+10);
    }
    public void event14(Data person){
        info="走在路上捡到五块钱";
        person.setMood(+10);
    }
    public void event15(Data person){
        info="找到一条好康的衣服";
        person.setMood(+5);
    }
}
