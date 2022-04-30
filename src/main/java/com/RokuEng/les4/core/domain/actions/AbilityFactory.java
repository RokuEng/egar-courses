package com.RokuEng.les4.core.domain.actions;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AbilityFactory {

	public Ability getLunge(int damage) {
		return u -> {
			u.applyToHp(-1 * damage);
		};
	}

}
