package kadai_10_4;

public class Magician extends Charactor {
	private int hp;
	private String name;
	private int at;
	private int df;
	private int mp;
	private int m_at;
	// 魔法での攻撃

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if (name == "null") {
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

	public int getMp() {
		return this.mp;
	}

	public void setMp(int mp) {
		if (mp < 0) {
			mp = 0;
		}
		this.mp = mp;
	}

	public int getM_at() {
		return this.m_at;
	}

	public void setM_at(int m_at) {
		if (m_at < 0) {
			m_at = 0;
		}
		this.m_at = m_at;
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

	public void magic_Attack() { // 魔法攻撃
		System.out.println(this.name + "は魔法で攻撃した！");
		System.out.println("怪物に" + this.m_at + "のダメージを与えた");
		this.mp = this.mp - 10;
		System.out.println("MPが１０ポイント消費し" + this.mp + "ポイントになった");
	}

	public void magic_Recovery() { // 回復魔法
		System.out.println(this.name + "は魔法で回復した");
		this.hp = this.hp + 10;
		System.out.println(this.name + "の体力が１０ポイント回復した");
		this.mp = this.mp - 5;
		System.out.println(this.name + "のMPが５ポイント消費し" + this.mp + "ポイントになった");
	}

	public void heal() {
		System.out.println(this.name + "は休憩をした");
		this.hp = this.hp + 10;
		System.out.println(this.name + "の体力が１０ポイント回復し、" + this.hp + "ポイントになった");
	}

	@Override
	public void defence() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(this.name + "は身を守った");
		this.df = this.df + 10;
		System.out.println("防御力が１０上がり、防御力が" + this.df + "ポイントになった");
	}
}
