package com.RokuEng.les4.core.domain.creature.hero;

import com.RokuEng.les4.core.domain.actions.Ability;
import com.RokuEng.les4.core.domain.actions.AbilityFactory;
import com.RokuEng.les4.core.domain.creature.Unit;
import com.RokuEng.les4.core.domain.item.trinket.Applyable;
import com.RokuEng.les4.core.domain.trait.Race;
import com.RokuEng.les4.core.domain.trait.race.Human;

public class Peasant extends Hero implements Human {

	private static final int counterAttackDamage = -10;

	public Peasant(int hp) {
		super(hp);
	}

	@Override
	void levelAbility(Unit enemy) {
		System.out.printf("Крестьянин не имеет уровня! ");
	}

	@Override
	public void attack(Unit unit) {

		if (unit.isDeath()) {
			System.out.printf("<%s> %s уже мёртв! ", this.getClass().getSimpleName(), unit.getClass().getSimpleName());
			return;
		}

		System.out.printf("<%s> Атакую %s своим серпом! ", this.getClass().getSimpleName(),unit.getClass().getSimpleName());
		unit.damage(this,AbilityFactory.getLunge(5));

		super.attack(unit);
	}

	@Override
	public void onAttack(Unit enemy) {

		getApplyables()
			.stream()
			.map(Applyable::ability)
			.forEach(ability -> ability.apply(this));

	}

	@Override
	public void onProtect(Unit enemy) {

		System.out.printf("<%s> Атакован %s! Контратакую на %d урона! ", this.getClass().getSimpleName(), enemy.getClass().getSimpleName(), -1*counterAttackDamage);
		enemy.damage(this,AbilityFactory.getLunge(counterAttackDamage));

		getApplyables()
			.stream()
			.map(Applyable::ability)
			.forEach(ability -> ability.apply(this));
	}

	@Override
	public void applyRace() {
		apply(race);
	}
}
