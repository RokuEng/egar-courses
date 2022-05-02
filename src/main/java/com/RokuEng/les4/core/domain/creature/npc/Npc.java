package com.RokuEng.les4.core.domain.creature.npc;

import com.RokuEng.les4.core.domain.actions.Ability;
import com.RokuEng.les4.core.domain.creature.Unit;

public abstract class Npc extends Unit {

	public Npc(int hp) {
		super(hp);
	}

	@Override
	public void attack(Unit unit) {

		if (unit.isDeath()) {
			return;
		}

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

	}

	@Override
	public void apply(Ability action) {
		action.apply(this);
	}
}
