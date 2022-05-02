package com.RokuEng.les4;

import com.RokuEng.les4.core.domain.actions.AbilityFactory;
import com.RokuEng.les4.core.domain.creature.HeroFactory;
import com.RokuEng.les4.core.domain.creature.NpcFactory;
import com.RokuEng.les4.core.domain.creature.hero.Hero;
import com.RokuEng.les4.core.domain.creature.hero.Peasant;
import com.RokuEng.les4.core.domain.item.ItemFactory;

public class Application {

	public static void main(String[] args) {

		Hero peasant = HeroFactory.getPeasant();
		Hero guard = HeroFactory.getGuard();
		Hero killer = HeroFactory.getKiller();

		peasant.attack(guard);

		System.out.println();

		guard.addProtectables(ItemFactory.getChestplate());

		System.out.println();

		peasant.addApplyables(ItemFactory.getHealthstone());

		System.out.println();

		peasant.attack(guard);

		System.out.println();

		guard.attack(peasant);

		System.out.println();

		guard.attack(peasant);

		System.out.println();

		guard.attack(peasant);

		System.out.println();

		guard.attack(peasant);

		System.out.println();

		guard.attack(NpcFactory.getSlime());

		System.out.println();

		guard.attack(NpcFactory.getSlime());

		System.out.println();

		killer.attack(guard);

	}

}
