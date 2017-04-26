package com.cn.chao.swiperecyclerview;

import java.util.ArrayList;

/**
 * Created by aChao on 2017/4/18.
 */

public class ItemContent {
    private String mName;

    public ItemContent(String name){
        mName=name;
    }


    public static ArrayList<String> createItemContent(){
        ArrayList<String> itemContents = new ArrayList<String>();
        for(int i=0;i<30;i++){
            String itemContent = new String();
            itemContent = "Item" + i;
            itemContents.add(itemContent);
        }
        return itemContents;
    }

    public static ArrayList<String> createItemContent2(){
        ArrayList<String> itemContents = new ArrayList<String>();
        for(int i=0;i<10;i++){
            String itemContent = new String();
            itemContent = "Item" + i;
            itemContents.add(itemContent);
        }
        return itemContents;
    }
}
