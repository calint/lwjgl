package d4.game;
import d4.win;
import d4.wld;
import d4.ob.objhous;
import d4.ph.vbos;
public class init{public init(final wld wd)throws Throwable{
	vbos.init();
	new objhous(wd);
	float s=8;
	final int n=(int)(s*8/3);
	float r=(float)Math.PI;
	float dy=s/n;
	float dx=dy;
	for(float y=-s;y<=s;y+=dy){
		for(float x=-s;x<=s;x+=dx){
			if(Math.sqrt(x*x+y*y)>r)
				continue;
			final win w=new win(wd,1,1);
			w.x=x;
			w.y=y;
			w.z=4;
		}
	}
}}
