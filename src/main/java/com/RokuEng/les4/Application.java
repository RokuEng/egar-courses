package com.RokuEng.les4;

import com.RokuEng.les4.core.domain.actions.AbilityFactory;
import com.RokuEng.les4.core.domain.creature.HeroFactory;
import com.RokuEng.les4.core.domain.creature.hero.Hero;
import com.RokuEng.les4.core.domain.creature.hero.Peasant;

public class Application {

	public static void main(String[] args) {

		Hero peasant = HeroFactory.getPeasant();
		Hero guard = HeroFactory.getGuard();

		System.out.println(peasant.getHp());
		System.out.println(guard.getHp());

		peasant.attack(guard);
		guard.attack(peasant);

		System.out.println(peasant.getHp());
		System.out.println(guard.getHp());
	}

}
