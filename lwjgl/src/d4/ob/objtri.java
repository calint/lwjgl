package d4.ob;
import d4.obj;
import d4.ph.vbos;
public class objtri extends obj{
	public objtri(){
		ph=vbos.polhs[1];
	}
	public void upd(){
		super.upd();
		a.z+=2;
	}
}