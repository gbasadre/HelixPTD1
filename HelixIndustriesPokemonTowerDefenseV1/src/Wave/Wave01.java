package Wave;

import java.awt.image.BufferedImage;

import Mob.MobBuilder;
import Mob.MobID;
import Mob.Pidgey;
import Mob.Rattata;

public class Wave01 extends Wave{
	private int delay = 1000;
	private int level = 1;
	
	public Wave01()
	{
		super();
		//MobBuilder m  = new MobBuilder();
		MobBuilder m = super.mobBuilder;
		for(int i = 0; i < 10; i++)
		{
			if(i % 2 == 0)
				add(m.buildMob(MobID.RATTATA));
			else
				add(m.buildMob(MobID.PIDGEY));
		}
	}
	
	public void setDelay(int delay){
		this.delay = delay;
	}
	public int getDelay(){
		return delay;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
