package com.RokuEng.les4.core.domain.creature;

import com.RokuEng.les4.core.domain.actions.Ability;
import lombok.Getter;

public abstract  class Unit {

	@Getter
	private int hp;

	public Unit(int hp) {
		this.hp = hp;
	}

	abstract public void damage(Ability action);

	abstract public void apply(Ability action);

	abstract public void attack(Unit unit);

	public void applyToHp(int value) {
		this.hp += value;
	}
}
