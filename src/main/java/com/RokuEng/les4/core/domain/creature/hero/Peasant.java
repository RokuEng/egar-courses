package com.RokuEng.les4.core.domain.creature.hero;

import com.RokuEng.les4.core.domain.actions.Ability;
import com.RokuEng.les4.core.domain.actions.AbilityFactory;
import com.RokuEng.les4.core.domain.creature.Unit;
import com.RokuEng.les4.core.domain.trait.Race;
import com.RokuEng.les4.core.domain.trait.race.Human;

public class Peasant extends Hero implements Human {

	public Peasant(int hp) {
		super(hp);
	}

	@Override
	public void attack(Unit unit) {
		unit.apply(AbilityFactory.getLunge(30));
	}

	@Override
	public void onAttack() {

	}

	@Override
	public void onProtect() {
		this.apply(
			u -> {
				applyToHp(10);
			}
		);
	}

	@Override
	public void applyRace() {
		apply(race);
	}
}
