package d4.ob;
import d4.obj;
public class obhous extends obj{
	public obhous(final obj pt){
		super(pt);
		final obj s=new obsq(this);
		s.y=.1f;
		;
		final obj r=new obtri(this);
		r.y=-.1f;
		r.z=.1f;
	}
	public void upd(){
		super.upd();
		a.z+=5;
		z+=.05f;if(z>10)z=0;
	}
}