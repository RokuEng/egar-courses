package com.RokuEng.les4.core.domain.creature.hero;

import com.RokuEng.les4.core.domain.actions.Ability;
import com.RokuEng.les4.core.domain.creature.Unit;
import com.RokuEng.les4.core.domain.trait.Profession;
import com.RokuEng.les4.core.domain.trait.Race;

public abstract class Hero extends Unit implements Race, Profession {

	public Hero(int hp) {
		super(hp);
	}

	@Override
	public void damage(Ability action) {
		action.apply(this);
		onProtect();
	}

	@Override
	public void apply(Ability action) {
		action.apply(this);
	}
}
