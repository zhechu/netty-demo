package com.wise.unpack.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

/**
 * @author lingyuwang
 * @date 2019-06-07 17:30
 */
public class UnpackClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte[] buffer = new byte[msg.readableBytes()];
        msg.readBytes(buffer);

        String message = new String(buffer, Charset.forName("UTF-8"));

        System.out.println("client receive msg body: " + message);
        System.out.println("client receive msg count: " + (++this.count));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            ByteBuf buffer = Unpooled.copiedBuffer("client msg body", Charset.forName("UTF-8"));
            ctx.writeAndFlush(buffer);
        }
    }
}
