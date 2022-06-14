package kadai_10_4;

import kadai_10_4.Magician;

public class SuperMagician extends Magician {

	//  超魔法攻撃                 
   public void super_magic_Attack() { 
      System.out.println(this.getName() + "は超攻撃魔法で攻撃した！");
      System.out.println("怪物に" + (this.getM_at())*2 + "のダメージを与えた");
      setMp(this.getMp() - 20);
      System.out.println("MPが２０ポイント消費し" + this.getMp() + "ポイントになった");
   // m2.setHp(m2.getHp()-(mg2.getM_at())*2);
   }

}
