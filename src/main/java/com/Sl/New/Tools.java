package com.Sl.New;

import java.io.File;

public class Tools {
    File file;
    public File getImg(String name){
        file=new File(name);
        return file;
    }
}
