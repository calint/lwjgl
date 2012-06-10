package d4;
import d4.ph.polhsq;
import d4.ph.polhtri;
public class vbos{
	public final static polh[] polhs=new polh[]{new polhsq(),new polhtri()};
	static void load()throws Throwable{
		for(final polh p:polhs)
			p.init();
	}
}
