package com.cwa.gamecore.io;

import com.cwa.gamecore.util.CompressionUtil;
import java.util.Date;

public abstract class AbstractGameOutput implements GameOutput {

    /**
     * 为了用int型，日期时间戳精确到秒。
     * @see GameOutput#putDate(java.util.Date) 
     */
    @Override
    public void putDate(Date date) {
        if (date == null) {
            putInt(0);
        } else {
            long time = date.getTime() / 1000;
            putInt((int) time);
        }
    }

    @Override
    public void putGzip(byte[] bytes) {
        byte[] gzip = CompressionUtil.gzip(bytes);
        putBytes(gzip);
    }
    
}
