package d4.ob;
import d4.obj;
public class objhous extends obj{
	public objhous(){
		final obj s=new objsq();
		s.p.y=.1f;
		chs.add(s);
		;
		final obj r=new objtri();
		r.p.y=-.1f;
		chs.add(r);
	}
	public void upd(){
		p.x+=.001;
//		a.z+=5;
		if(chs.isEmpty())
			return;
		for(final obj o:chs){
			o.upd();
		}
	}
}