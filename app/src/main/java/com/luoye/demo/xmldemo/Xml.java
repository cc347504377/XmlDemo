package com.luoye.demo.xmldemo;


import android.util.Log;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Luoye on 2016/11/2.
 */

public class Xml implements Parser{
    public static Xml xml = new Xml();

    public static Xml getinstance() {
        return xml;
    }
    public List<Info> parse(InputStream inputStream) throws Exception {
        //获得解析器
        XmlPullParser parser = android.util.Xml.newPullParser();
        //为解析器设置数据源
        parser.setInput(inputStream, "GBK");
        //通过解析器获得事件的类型
        int eventType;
        //判断获得的解析事件
        List<Info> datas = null;
        Info info = null;
        eventType = parser.getEventType();
        //第一次必须用.geteventtype 不能直接用next 否则不能获得开始事件
        while (eventType != XmlPullParser.END_DOCUMENT) {
            switch (eventType) {
                //开始解析文档
                case XmlPullParser.START_DOCUMENT:
                    datas = new ArrayList<>();
                    Log.i("TAG", "start document");
                break;
                //开始标签事件
                case XmlPullParser.START_TAG:
                    Log.i("TAG", "start tag");
                    String tagname = parser.getName();
                    if ("book".equals(tagname)) {
                        info =  new Info();
                    } else if ("title".equals(tagname)) {
                        info.setTitle(parser.nextText());
                    } else if ("author".equals(tagname)) {
                        info.setAuthor(parser.nextText());
                    } else if ("year".equals(tagname)) {
                        info.setYear(Integer.parseInt(parser.nextText()));
                    } else if ("price".equals(tagname)) {
                        info.setPrice(Float.valueOf(parser.nextText()));
                    }
                break;
                //结束标签事件
                case XmlPullParser.END_TAG:
                    if ("book".equals(parser.getName())) {
                        datas.add(info);
                        info = null;
                    }
                    break;
                //结束文档

            }
            eventType = parser.next();
        }
        return datas;
    }
}
