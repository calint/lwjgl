package d4.ob;
import d4.obj;
import d4.ph.tri;
import d4.ph.vbos;
public class obtri extends obj{
	public obtri(final obj pt){
		super(pt);
		ph=vbos.get(tri.class);
	}
	public void upd(){
		super.upd();
		a.z+=2;
	}
}