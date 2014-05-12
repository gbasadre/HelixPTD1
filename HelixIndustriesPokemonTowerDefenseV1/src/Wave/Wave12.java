package Wave;

import java.awt.image.BufferedImage;

import Mob.Meowth;
import Mob.Oddish;
import Mob.Bellsprout;
import Mob.Venonat;
import Mob.Pidgeotto;
import Mob.Weedle;
import Mob.Caterpie;


public class Wave12 extends Wave{

	private int delay = 1000;
	private int level = 12;

	public Wave12(){
		super();
		MobBuilder m = super.mobBuilder;
		for(int i = 0; i < 180; i++){
			if(i % 49 == 0)
				add(new Meowth(meowth));
			if(i < 35){
				if(i % 2 == 0)
					add(new Caterpie(caterpie));
				else
					add(new Weedle(weedle));
			}
			else if(i > 35 && i < 95){
				if(i % 2 == 0)
					add(new Oddish(oddish));
				else
					add(new Bellsprout(bellsprout));
			}
			else if(i > 95 && i < 175){
				if(i % 2 == 0)
					add(new Venonat(venonat));
				if(i % 3 == 0)
					add(new Oddish(oddish));
				else
					add(new Bellsprout(bellsprout));
			}
			else
				add(new Pidgeotto(pidgeotto));
		}
	}

}
