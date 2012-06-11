package d4.ob;
import d4.obj;
import d4.ph.sq;
import d4.ph.vbos;
public class obsq extends obj{
	public obsq(final obj pt){
		super(pt);
		ph=vbos.get(sq.class);
	}
}