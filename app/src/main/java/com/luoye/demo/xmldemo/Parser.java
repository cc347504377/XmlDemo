package com.luoye.demo.xmldemo;

import java.io.InputStream;
import java.util.List;
import java.util.Objects;

/**
 * Created by Luoye on 2016/11/2.
 */

public interface Parser {
    List<Info> parse(InputStream inputStream) throws Exception;
}
