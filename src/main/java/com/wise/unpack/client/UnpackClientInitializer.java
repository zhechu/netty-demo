package com.wise.unpack.client;

import com.wise.unpack.CustomProtocolDecoder;
import com.wise.unpack.CustomProtocolEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author lingyuwang
 * @date 2019-06-07 17:22
 */
public class UnpackClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();

        channelPipeline.addLast(new CustomProtocolDecoder());
        channelPipeline.addLast(new CustomProtocolEncoder());
        channelPipeline.addLast(new UnpackClientHandler());
    }

}
