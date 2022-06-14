package kadai_10_4;

public class Hero extends Charactor {

	private String name;
	private int hp;
	private int at;
	private int df;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if (name == (null)) {
			throw new IllegalArgumentException("名前がnullです");
		}
		if ((name.length() < 3) || (name.length() > 10)) {
			throw new IllegalArgumentException("文字数は3文字以上、１０文字以下で入力してください");
		}
		this.name = name;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		if (hp < 0) {
			hp = 0;
		}
		this.hp = hp;
	}

	public int getAt() {
		return this.at;
	}

	public void setAt(int at) {
		if (at < 0) {
			at = 0;
		}
		this.at = at;
	}

	public int getDf() {
		return this.df;
	}

	public void setDf(int df) {
		if (df < 0) {
			df = 0;
		}
		this.df = df;
	}

	@Override
	public void attack() {
		System.out.println(this.name + "の攻撃！！");
		System.out.println("怪物に" + this.at + "ポイントのダメージを与えた！！");

	}

	@Override
	public void defence() {
		System.out.println(this.name + "は身を守った");
		this.df = this.df + 10;
		System.out.println("防御力が１０上がり、防御力が" + this.df + "ポイントになった");
	}

	public void heal() {
		System.out.println(this.name + "は休憩した");
		this.hp = this.hp + 10;
		System.out.println(this.name + "の体力が１０回復し、" + this.hp + "ポイントになった");
	}
}