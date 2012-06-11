package d4.game;
import d4.wld;
import d4.ob.obhous;
import d4.ph.vbos;
public class init{public init(final wld wd)throws Throwable{
	vbos.polhs.put(dotph.class,new dotph());
	vbos.init();
	new obhous(wd);
	new hud(wd);
}}
