package com.RokuEng.les4.core.domain.actions;

import com.RokuEng.les4.core.domain.creature.Unit;
import com.RokuEng.les4.core.domain.item.armor.Protectable;
import com.RokuEng.les4.core.domain.item.trinket.Applyable;

import java.util.function.Consumer;

@FunctionalInterface
public interface Ability {
	void apply(Unit unit);

	default void applyTo(Unit unit) {
		this.apply(unit);
	}
}
