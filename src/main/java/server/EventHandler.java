package server;


import io.netty.buffer.ByteBuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Handles a server-side channel.
 */
public class EventHandler extends ChannelInboundHandlerAdapter { // (1)

	 @Override
	    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
	        // Discard the received data silently.
		 ByteBuf in = (ByteBuf) msg;
	        while (in.isReadable()) { // (1)
	            System.out.print((char) in.readByte());
	            System.out.flush();
	        }
	    }

	    @Override
	    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
	        // Close the connection when an exception is raised.
	        cause.printStackTrace();
	        ctx.close();
	    }
}