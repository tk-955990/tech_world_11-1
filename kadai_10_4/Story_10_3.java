package kadai_10_4;

import java.util.Scanner;
import kadai.Story;

public class Story_10_3 {
	public static void main(String[] args) {

		// 勇者の生成

		SuperHero h2 = new SuperHero();
		h2.setName("roto");
		h2.setHp     (500);
		h2.setAt      (50);
		h2.setDf      (80);

		System.out.println("誇り高き勇者が今ここに誕生した");
		System.out.println("名前:" + h2.getName());
		System.out.println("体力:"   + h2.getHp());
		System.out.println("攻撃力:" + h2.getAt());
		System.out.println("防御力:" + h2.getDf());

		// 怪物の生成

		SuperMonster m2 = new SuperMonster();
		m2.setName("kaiju");
		m2.setHp     (1000);
		m2.setAt      (100);
		m2.setDf      (120);
		m2.setP_at     (50);
		m2.setPoison    (5);

		System.out.println("禍々しい怪物がここに誕生した");
		System.out.println("名前:"     + m2.getName());
		System.out.println("体力:"     + m2.getHp());
		System.out.println("攻撃力:"   + m2.getAt());
		System.out.println("防御力:"   + m2.getDf());
		System.out.println("毒攻撃力:" + m2.getP_at());
		System.out.println("独針の数:" + m2.getPoison());

		// 魔法使いの生成

		SuperMagician mg2 = new SuperMagician();
		mg2.setName("medeia");
		mg2.setHp       (500);
		mg2.setAt        (30);
		mg2.setMp        (50);
		mg2.setM_at      (50);
		mg2.setDf       (100);

		System.out.println("魔法使いがここに誕生した");
		System.out.println("名前:"       + mg2.getName());
		System.out.println("体力:"       + mg2.getHp());
		System.out.println("攻撃力:"     + mg2.getAt());
		System.out.println("MP:"         + mg2.getMp());
		System.out.println("攻撃魔法力:" + mg2.getM_at());

		System.out.println("========= Game Start !! ================");
		Scanner scanner = new Scanner(System.in);

		boolean b1 = (h2.getHp() <= 0);
		boolean b2 = (mg2.getHp() <= 0);
		boolean b3 = (m2.getHp() <= 0);
		b1 = true;
		b2 = true;
		b3 = true;

		while ((b1 && b2) || b3) {

			if (h2.getHp() <= 0)
				System.out.println(h2.getName() + "は死んでいる");
			else {

				// 勇者のターン

				System.out.println("<<   　勇者の作戦は？   >>");
				System.out.println("攻撃:1 防御:2 休憩:3 終了:4");

				int get_hCommand = new java.util.Scanner(System.in).nextInt();

				switch (get_hCommand) {
				case 1:
					h2.attack();
					m2.setHp(m2.getHp() - (h2.getAt()) * 2);
					break;
				case 2:
					h2.defence();
					break;
				case 3:
					h2.heal();
					break;
				case 4:
				}
				status(h2, mg2, m2);
			}
			if (m2.getHp() <= 0) {
				System.out.println("@@@@@@@@@@@  " + m2.getName() + "  を倒した  @@@@@@@@@@");
				System.out.println("========= You Winn !! ==================");
				break;
			} else
				System.out.println("勇者のターン終了");
			System.out.println("----------------------------------------");

			if (mg2.getHp() <= 0)
				System.out.println("魔法使いは死んでる");
			else {

				// 魔法使いのターン
				System.out.println("<<   魔法使いの作戦は？   >>");

				if (mg2.getMp() >= 20) {
					System.out.println("攻撃:1 攻撃魔法:2 超攻撃魔法:3");
					System.out.println("回復魔法:4 防御:5 休憩:6 終了:7");
				}
				if ((mg2.getMp() < 20) && (mg2.getMp() >= 10)) {
					System.out.println("攻撃:1 攻撃魔法:2 回復魔法:4");
					System.out.println(" 防御:5 休憩:6 終了:7");
				}
				if ((mg2.getMp() < 10) && (mg2.getMp() >= 5)) {
					System.out.println("攻撃:1 回復魔法:4 防御:5 休憩:6 終了:7");
				}
				if (mg2.getMp() < 5) {
					System.out.println("攻撃:1 防御:5 休憩:6 終了:7");
				}

				int get_mgCommand = new java.util.Scanner(System.in).nextInt();

				switch (get_mgCommand) {
				case 1:
					mg2.attack();
					m2.setHp(m2.getHp() - mg2.getAt());
					break;
				case 2:
					mg2.magic_Attack();
					m2.setHp(m2.getHp() - mg2.getM_at());
					break;
				case 3:
					mg2.super_magic_Attack();
					m2.setHp(m2.getHp() - (mg2.getM_at()) * 2);
					break;
				case 4:
					mg2.magic_Recovery();
					break;
				case 5:
					mg2.defence();
					break;
				case 6:
					mg2.heal();
					break;
				case 7:
					break;

				}
				status(h2, mg2, m2);
			}
			if (m2.getHp() <= 0) {
				System.out.println("@@@@@@@@@@@  " + m2.getName() + "  を倒した  @@@@@@@@@@");
				System.out.println("========= You Winn !! ==================");
				break;
			} else {
				System.out.println("魔法使いのターン終了");
				System.out.println("----------------------------------------");
			}

			// モンスターのターン
			if ((mg2.getHp() > 0) && (h2.getHp() > 0)) {
				int random = (int) (Math.random() * 5);
				switch (random) {
				case 0:
					attack_h2(h2, m2);
					break;
				case 1:
					attack_mg2(mg2, m2);
					break;
				case 2:
					p_attack_h2(m2, h2);
					break;
				case 3:
					p_attack_mg2(m2, mg2, h2);
					break;
				case 4:
					m2.defence();
					break;
				}
				status(h2, mg2, m2);
				if ((mg2.getHp() <= 0) && (h2.getHp() <= 0)) {
					System.out.println("============= game over ================");
					break;
				} else
					System.out.println("モンスターのターン終了");
				System.out.println("----------------------------------------");
				continue;

				// 魔法使いが死んでいる時

			}
			if ((mg2.getHp() <= 0) && (h2.getHp() > 0)) {
				int random = (int) (Math.random() * 3);
				switch (random) {
				case 0:
					attack_h2(h2, m2);
					break;
				case 1:
					p_attack_h2(m2, h2);
					break;
				case 2:
					m2.defence();
					break;
				}
				status(h2, mg2, m2);
				if ((mg2.getHp() <= 0) && (h2.getHp() <= 0)) {
					System.out.println("============= game over ================");
					break;
				} else
					System.out.println("モンスターのターン終了");
				System.out.println("----------------------------------------");
				continue;

				// 勇者が死んでいる時

			}
			if ((mg2.getHp() > 0) && (h2.getHp() <= 0)) {
				int random = (int) (Math.random() * 3);
				switch (random) {
				case 0:
					attack_mg2(mg2, m2);
					break;
				case 1:
					p_attack_mg2(m2, mg2, h2);
					break;
				case 2:
					m2.defence();
					break;
				}
				status(h2, mg2, m2);
				if ((mg2.getHp() <= 0) && (h2.getHp() <= 0)) {
					System.out.println("============= game over ================");
					break;
				} else
					System.out.println("モンスターのターン終了");
				System.out.println("----------------------------------------");
				continue;
			}
		}
	}

	public static void status(SuperHero h2, SuperMagician mg2, SuperMonster m2) {
		System.out.println("【"      + h2.getName() + ":ステータス】");
		System.out.println("体力:"   + h2.getHp());
		System.out.println("攻撃力:" + h2.getAt());
		System.out.println("防御力:" + h2.getDf());

		System.out.println("【"      + mg2.getName() + ":ステータス】");
		System.out.println("体力:"   + mg2.getHp());
		System.out.println("攻撃力:" + mg2.getAt());
		System.out.println("防御力:" + mg2.getDf());
		System.out.println("MP:"     + mg2.getMp());

		System.out.println("【"        + m2.getName() + ":ステータス】");
		System.out.println("体力:"     + m2.getHp());
		System.out.println("攻撃力:"   + m2.getAt());
		System.out.println("防御力:"   + m2.getDf());
		System.out.println("独針の数:" + m2.getPoison());
	}

	public static void attack_h2(SuperHero h2, SuperMonster m2) {
		m2.attack1(h2);
		if (h2.getHp() <= 0)
			System.out.println("@@@@@@@@@@@  " + h2.getName() + "  は死んだ  @@@@@@@@@@");
	}

	public static void attack_mg2(SuperMagician mg2, SuperMonster m2) {
		m2.attack2(mg2);
		if (mg2.getHp() <= 0)
			System.out.println("@@@@@@@@@@@  " + mg2.getName() + "  は死んだ  @@@@@@@@@@");
	}

	public static void p_attack_h2(SuperMonster m2, SuperHero h2) {
		m2.attack1(h2);
		if (m2.getPoison() > 0) {
			m2.poison_Attack1(h2);
		}
		if (h2.getHp() <= 0)
			System.out.println("@@@@@@@@@@@  " + h2.getName() + "  は死んだ  @@@@@@@@@@");
	}

	public static void p_attack_mg2(SuperMonster m2, SuperMagician mg2, SuperHero h2) {
		m2.attack2(mg2);
		if (m2.getPoison() > 0) {
			m2.poison_Attack2(mg2);
		}
		if (h2.getHp() <= 0)
			System.out.println("@@@@@@@@@@@  " + h2.getName() + "  は死んだ  @@@@@@@@@@");
	}

}