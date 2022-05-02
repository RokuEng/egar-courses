package com.RokuEng.les4.core.domain.creature.hero;

import com.RokuEng.les4.core.domain.creature.Unit;

public class Killer extends Hero {
	public Killer(int hp) {
		super(hp);
	}

	@Override
	public void attack(Unit unit) {

		System.out.printf("<%s> Смерть пришла за тобой <%s> ", this.getClass().getSimpleName(), unit.getClass().getSimpleName());

		super.attack(unit);
		unit.damage(this,u -> u.applyToHp(-999999));
	}

	@Override
	void levelAbility(Unit enemy) {

	}

	@Override
	public void onAttack(Unit enemy) {

	}

	@Override
	public void onProtect(Unit protectFrom) {

	}

	@Override
	public void applyRace() {

	}
}
