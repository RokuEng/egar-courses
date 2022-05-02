package com.RokuEng.les4.core.domain.creature.hero;

import com.RokuEng.les4.core.domain.actions.Ability;
import com.RokuEng.les4.core.domain.creature.Unit;
import com.RokuEng.les4.core.domain.trait.Profession;
import com.RokuEng.les4.core.domain.trait.Race;

public abstract class Hero extends Unit implements Race, Profession {

	protected int lvl;

	public Hero(int hp) {
		super(hp);
	}

	abstract void levelAbility(Unit enemy);

	@Override
	public void attack(Unit unit) {

		if (unit.isDeath()) {
			return;
		}

		onAttack(unit);

		if (unit.isDeath()) {
			unit.death(this);
		}
	}

	@Override
	public void damage(Unit fromTarget, Ability action) {
		action.apply(this);

		if (this.isDeath()) {
			this.death(fromTarget);
			return;
		}

		onProtect(fromTarget);
	}

	@Override
	public void apply(Ability action) {
		action.apply(this);
	}

	public void updateLvl() {
		System.out.printf("Новый уровень! ");
		this.lvl += 1;
	}
}
