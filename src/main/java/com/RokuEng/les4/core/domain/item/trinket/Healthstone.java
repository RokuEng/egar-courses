package com.RokuEng.les4.core.domain.item.trinket;

import com.RokuEng.les4.core.domain.actions.Ability;

public class Healthstone implements Applyable {

	private final int value = 10;

	@Override
	public Ability ability() {
		return u -> {
			System.out.printf("Применён [%s]! Излечено %d ХП! ", this.getClass().getSimpleName(), value);
			u.applyToHp(value);
		};
	}
}
