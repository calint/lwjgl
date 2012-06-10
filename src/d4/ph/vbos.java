package d4.ph;
import d4.polh;
public final class vbos{
	public final static polh[] polhs=new polh[]{new polhsq(),new polhtri()};
	public static void init()throws Throwable{
		for(final polh p:polhs)
			p.init();
	}
}
