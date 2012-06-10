package a.d4;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import b.a;
import b.sock;
import b.thdwatch;

public class net extends a implements sock{
	private static final long serialVersionUID=1;
	public final static int pklen=32;
	private SocketChannel sockch;
	private ByteBuffer bb=ByteBuffer.allocate(pklen);
	public niop sockinit(final SocketChannel sc)throws Throwable{
		this.sockch=sc;
		return niop.read;
	}
	public niop read() throws Throwable{
		while(true){
			final int c=sockch.read(bb);
			if(c==-1)
				return niop.close;
			if(c==0)
				return niop.read;
			System.out.println(this+" "+new String(bb.array()));
			bb.flip();
			final niop r=parse();
			if(r==niop.more){
				continue;
			}
			return r;
		}
	}
	private niop parse()throws Throwable{
		return niop.write;
	}
	public niop write() throws Throwable{
		while(true){
			final int c=sockch.write(bb);
			if(c==-1)
				return niop.close;
			if(c==0)
				return niop.write;
			thdwatch.output+=c;
			if(bb.remaining()==0)
				break;
		}
		bb.clear();
		return niop.read;
	}
}
