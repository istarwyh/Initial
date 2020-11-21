package com.github.istarwyh.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Description: AWriter
 * @Author: AZURE99 https://www.rainng.com/java-acm-fast-io/
 * @Date:  2019-05-12
 * @Version: 1.0.0
 *
 * Reader内部使用BufferedReader的nextLine方法从输入流读取数据，由内部方法innerNextLine包装，同样使用StringTokenizer分片。
 * hasNext方法会检查是否还有数据，它通过读入新数据并创建tokenizer来寻找下一个可用的token。
 * 因此，调用hasNext方法后，会确保调用tokenizer.nextToken()时可以得到数据，除非已经读取到输入流尾。
 * nextLine方法会读入一行新数据，同时舍弃tokenizer中的内容。next方法会返回下一个数据。nextXXX方法将next的数据包装成常见数据类型。
 */
public class AWriter {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer = new StringTokenizer("");
    private String innerNextLine() {
        try {
            return reader.readLine();
        } catch (IOException ex) {
            return null;
        }
    }
    public boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String nextLine = innerNextLine();
            if (nextLine == null) {
                return false;
            }
            tokenizer = new StringTokenizer(nextLine);
        }
        return true;
    }
    public String nextLine() {
        tokenizer = new StringTokenizer("");
        return innerNextLine();
    }
    public String next() {
        hasNext();
        return tokenizer.nextToken();
    }
    public int nextInt() {
        return Integer.parseInt(next());
    }
}
