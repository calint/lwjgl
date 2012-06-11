package d4.game;
import d4.wld;
import d4.ob.objhous;
import d4.ph.vbos;
public class init{public init(final wld wd)throws Throwable{
	vbos.init();
	new objhous(wd);
	new hud(wd);
}}
