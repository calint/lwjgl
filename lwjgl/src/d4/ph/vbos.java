package d4.ph;
import java.util.HashMap;
import java.util.Map;
import d4.polh;
public final class vbos{
	public final static Map<Class<? extends polh>,polh>polhs=new HashMap<Class<? extends polh>,polh>();
	static{
		polhs.put(sq.class,new sq());
		polhs.put(tri.class,new tri());
	}
	public static void init()throws Throwable{
		for(final polh p:polhs.values())
			p.init();
	}
}
