package d4.ph;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import d4.polh;
public final class vbos{
	final static Map<Class<? extends polh>,polh>polhs=new HashMap<Class<? extends polh>,polh>();
	static{
		polhs.put(sq.class,new sq());
		polhs.put(tri.class,new tri());
	}
	public static void init()throws Throwable{
		for(final polh p:polhs.values())
			p.init();
	}
	public static void add(final Collection<polh>c){
		for(final polh p:c)
			polhs.put(p.getClass(),p);
	}
	public static polh get(final Class<? extends polh>c){
		final polh p=polhs.get(c);
		if(p==null)throw new Error("notfound "+c);
		return p;
	}
}
