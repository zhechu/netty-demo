package com.wise;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * @author lingyuwang
 * @date 2019-06-25 23:04
 */
public class ByteBufTest {

    @Test
    public void useTest() {
        ByteBuf byteBuf = Unpooled.buffer(10);

        for (int i = 0; i < 10; i++) {
            byteBuf.writeByte(i);
        }

        for (int i = 0; i < byteBuf.capacity(); i++) {
            System.out.println(byteBuf.getByte(i));
        }
    }

    @Test
    public void headBufTest() {
        ByteBuf byteBuf = Unpooled.copiedBuffer("hello world", Charset.forName("utf-8"));

        if (byteBuf.hasArray()) {
            byte[] content = byteBuf.array();
            System.out.println(new String(content, Charset.forName("utf-8")));

            System.out.println(byteBuf);

            System.out.println(byteBuf.arrayOffset());
            System.out.println(byteBuf.readerIndex());
            System.out.println(byteBuf.writerIndex());
            System.out.println(byteBuf.capacity());

            System.out.println(byteBuf.readableBytes());

            System.out.println(byteBuf.getCharSequence(0, 4, Charset.forName("utf-8")));
            System.out.println(byteBuf.getCharSequence(4, 6, Charset.forName("utf-8")));
        }
    }

    @Test
    public void compositeTest() {
        CompositeByteBuf compositeByteBuf = Unpooled.compositeBuffer();

        ByteBuf headBuf = Unpooled.buffer(10);
        ByteBuf directBuf = Unpooled.directBuffer(8);

        compositeByteBuf.addComponents(headBuf, directBuf);
//        compositeByteBuf.removeComponent(0);

        Iterator<ByteBuf> iterator = compositeByteBuf.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        compositeByteBuf.forEach(System.out::println);
    }

}
