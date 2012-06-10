package d4;
import java.util.Iterator;
import d4.ob.objhous;
public final class wld extends obj{
	public wld(){
		chs.add(new objhous());
	}
	public Iterator<obj>all(){
		return chs.iterator();
	}
}
