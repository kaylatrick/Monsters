package monsters;

import java.util.Random;


abstract public class Monster {
	
	public static Random r = new Random();

	private String name;
	public int health = 10;
	private int attackPower;
//	public static int activeDamage = r.nextInt(10);
	
	abstract public boolean isAlive(int health);
	abstract public void takeDamage(int damage);
	abstract public void attack(Monster lt);
	
	public static void loop(Hero hercules, Monster activeMonster) {
		while (hercules.health > 0 && activeMonster.health > 0) {
			hercules.attack(activeMonster);
			System.out.println(activeMonster + " has been hit.");
			System.out.println("Hercules score: " + hercules.health + " " + activeMonster + " score: " + activeMonster.health);
			if(activeMonster.health <= 0) {
				break;
			}
			activeMonster.attack(hercules);
			System.out.println("Hercules has been hit.");
			System.out.println("Hercules score: " + hercules.health + " " + activeMonster + " score: " + activeMonster.health);
		}
		if(activeMonster.health <= 0) {
			System.out.println(activeMonster + " was defeated!");
		} else {
			System.out.println("Hercules was defeated!");
		}
	}
	
	public static void main(String[] args) {
		Hero hercules = new Hero();
		
		Monster[] creatures = new Monster[3];
		creatures[0] = new Rat();
		creatures[1] = new Ogre();
		creatures[2] = new Goblin();
		Monster activeMonster = creatures[Monster.r.nextInt(3)];
//		System.out.println(activeMonster);
//		System.out.println(activeDamage);
//		System.out.println(hercules.health);
//		System.out.println(creatures[0].health);
//		System.out.println(new Rat().health);
//		creatures[0].takeDamage(activeDamage);
		Monster.loop(hercules, activeMonster);
	}

}

class Rat extends Monster {
	
	public boolean isAlive(int health) {
		if(this.health > 0) {
		return true;
	} else {return false;}
		}
	
	public void takeDamage(int damage) {
		this.health = this.health - damage;
//		System.out.println(this.health);
		if(isAlive(this.health) == true) {
//			System.out.println("I'm not dead.");
		};
	}
    public void attack(Monster lt) {
    	int ran = Monster.r.nextInt(9)+1;
    	lt.takeDamage(ran);
    }
	
}

class Ogre extends Monster {
	
	public boolean isAlive(int health) {
		return true;
	}
	
	public void takeDamage(int damage) {
		this.health -= damage;
	}

    public void attack(Monster lt) {
    	int ran = Monster.r.nextInt(9)+1;
    	lt.takeDamage(ran);
    }
}

class Goblin extends Monster {
	
	public boolean isAlive(int health) {
		return true;
	}
	
	public void takeDamage(int damage) {
		this.health -= damage;
	}

    public void attack(Monster lt) {
    	int ran = Monster.r.nextInt(9)+1;
    	lt.takeDamage(ran);
    }
}

class Hero extends Monster {
	int health = 10;
	
	public void fight(Monster activeMonster) {
		
	}
	
	public boolean isAlive(int health) {
		if(health > 0) {
		return true;
	} else {return false;}
		}
	
	public void takeDamage(int damage) {
		this.health -= damage;
//		System.out.println(this.health);
//		if(isAlive(this.health) == true) {
//			System.out.println("I'm not dead.");
		};
	

    public void attack(Monster lt) {
    	int ran = Monster.r.nextInt(9)+1;
    	lt.takeDamage(ran);
    }
}
