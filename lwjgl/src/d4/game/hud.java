package d4.game;
import d4.obj;
public class hud extends obj{
	public hud(obj parent){
		super(parent);
//		ph=vbos.get(hudph.class);
		final float s=8;
		final int n=(int)(s*8/3);
		float r=(float)Math.PI*2;
		float dy=s/n;
		float dx=dy;
		for(float y=-s;y<=s;y+=dy){
			for(float x=-s;x<=s;x+=dx){
				if(Math.sqrt(x*x+y*y)>r)
					continue;
				final obj o=new dot(this);
				o.x=x;
				o.y=y;
				o.z=4;
			}
		}
	}
	public void upd(){
		super.upd();
		z-=.15;if(z<-10)z=20;
		a.x+=1;
		a.y+=1;
		a.z+=1;
	}
}
