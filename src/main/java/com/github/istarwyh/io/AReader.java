package com.github.istarwyh.io;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @Description: AWriter
 * @Author: AZURE99 https://www.rainng.com/java-acm-fast-io/
 * @Date:  2019-05-12
 * @Version: 1.0.0
 *
 *  Writer则是对BufferedWriter的简单包装，提供了接受Object的print和println方法。
 *  注意，程序结束前一定要调用Writer的close()方法来刷新缓冲区并关闭输出流
 */
public class AReader implements Closeable {
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public void print(Object object) throws IOException {
        writer.write(object.toString());
    }
    public void println(Object object) throws IOException {
        writer.write(object.toString());
        writer.write("\n");
    }
    @Override
    public void close() throws IOException {
        writer.close();
    }
}
