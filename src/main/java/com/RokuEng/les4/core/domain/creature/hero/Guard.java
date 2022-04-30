package com.RokuEng.les4.core.domain.creature.hero;

import com.RokuEng.les4.core.domain.actions.Ability;
import com.RokuEng.les4.core.domain.actions.AbilityFactory;
import com.RokuEng.les4.core.domain.creature.Unit;
import com.RokuEng.les4.core.domain.trait.race.Human;

public class Guard extends Hero implements Human {

	public Guard(int hp) {
		super(hp);
	}

	@Override
	public void attack(Unit unit) {
		unit.damage(AbilityFactory.getLunge(50));
	}

	@Override
	public void onAttack() {
		applyToHp(-10);
	}

	@Override
	public void onProtect() {
		applyToHp(100);
	}

	@Override
	public void applyRace() {
		apply(race);
	}
}
