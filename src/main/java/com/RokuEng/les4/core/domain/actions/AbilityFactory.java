package com.RokuEng.les4.core.domain.actions;

import com.RokuEng.les4.core.domain.actions.abilities.Damage;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.function.Function;

@UtilityClass
public class AbilityFactory {

	public Ability getLunge(int damage) {
		return new Damage(damage);
	}
}
