package com.RokuEng.les4.core.domain.creature;

import com.RokuEng.les4.core.domain.creature.hero.Guard;
import com.RokuEng.les4.core.domain.creature.hero.Hero;
import com.RokuEng.les4.core.domain.creature.hero.Peasant;
import lombok.experimental.UtilityClass;

@UtilityClass
public class HeroFactory {
	public Hero getPeasant() {
		return new Peasant(100);
	}

	public Hero getGuard() {
		return new Guard(100);
	}
}
