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
	private ByteBuffer bbout=ByteBuffer.allocate(pklen);
	public niop sockinit(final SocketChannel sc)throws Throwable{
		this.sockch=sc;
		final byte[]ba=b.b.tobytes(b.b.hello+"\n> ");
		bbout.put(ba,0,ba.length<bb.capacity()?ba.length:bb.capacity());
		bbout.flip();
		return send();
	}
	public niop write()throws Throwable{
		return send();
	}
	public niop read() throws Throwable{//?
		while(true){
			if(bb.remaining()==0){
				bb.clear();
				final int c=sockch.read(bb);
				if(c==-1)
					return niop.close;
				if(c==0)
					return niop.read;
				bb.flip();
			}
			final niop r=parse();
			if(r==niop.read&&bb.remaining()>0)
				continue;
			if(r==niop.write)
				if(send()==niop.write)
					return niop.write;
		}
	}
	private niop parse()throws Throwable{
		bbout.put(bb);
		bbout.flip();
		return niop.write;
	}
	private niop send() throws Throwable{
		while(true){
			final int c=sockch.write(bbout);
			if(c==-1)
				return niop.close;
			if(c==0)
				return niop.write;
			thdwatch.output+=c;
			if(bbout.remaining()==0)
				break;
		}
		bbout.clear();
		return read();
	}
}
