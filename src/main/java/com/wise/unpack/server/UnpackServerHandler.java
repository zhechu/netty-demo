package com.wise.unpack.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.UUID;

/**
 * @author lingyuwang
 * @date 2019-06-07 17:30
 */
public class UnpackServerHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte[] buffer = new byte[msg.readableBytes()];
        msg.readBytes(buffer);

        String message = new String(buffer, Charset.forName("UTF-8"));

        System.out.println("server receive msg body: " + message);
        System.out.println("server receive msg count: " + (++this.count));

        ByteBuf responseByteBuf = Unpooled.copiedBuffer(UUID.randomUUID().toString(), Charset.forName("UTF-8"));
        ctx.writeAndFlush(responseByteBuf);
    }

}
