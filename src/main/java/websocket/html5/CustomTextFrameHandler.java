package websocket.html5;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class CustomTextFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx,
			TextWebSocketFrame msg) throws Exception {
		// TODO Auto-generated method stub
		String request = msg.text();
        ctx.channel().writeAndFlush(new TextWebSocketFrame(request.toUpperCase()));	
	}
}