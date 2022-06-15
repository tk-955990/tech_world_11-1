package kadai_10_4;

public abstract class Creature {
	protected int hp;
	protected String name;
	protected int at;
	protected int df;

	public abstract void attack1(Hero h);

	public abstract void attack2(Magician mg);

	public abstract void defence();

}
