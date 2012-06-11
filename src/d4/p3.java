package d4;
public class p3{
	public float x,y,z;
	public p3(){x=y=z=0;}
	public p3(float x,float y,float z){this.x=x;this.y=y;this.z=z;}
	public final p3 set(final p3 p){x=p.x;y=p.y;z=p.z;return this;}
	public static p3 vec(final p3 a,final p3 b){return new p3(b.x-a.x,b.y-a.y,b.z-a.z);}
	public final float magn(){return (float)Math.sqrt(x*x+y*y+z*z);}
}