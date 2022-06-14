package kadai_10_4;

public abstract class Creature {
	private int hp;
	private String name;
	private int at;
	private int df;
	
	public abstract void attack1(Hero h);
	public abstract void attack2(Magician mg);
    public abstract void defence();


}
