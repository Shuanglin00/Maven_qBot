package com.Sl.New;

import java.io.File;
import java.util.Random;

public class NewData {
    /*
    总储存
    初始化 定义
     */
    protected static String[] foods={};
    protected static String[] gifs={};
    public static String getFoods() {
        Random random=new Random();
        return foods[random.nextInt(foods.length)];
    }
    public static String getGifs() {
        Random random =new Random();
        return gifs[random.nextInt(gifs.length)];
    }
//    public static File getHead(){
//        File file =new File();
//        return file;
//    }
}
