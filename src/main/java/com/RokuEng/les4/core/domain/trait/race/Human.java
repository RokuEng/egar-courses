package com.RokuEng.les4.core.domain.trait.race;

import com.RokuEng.les4.core.domain.actions.Ability;
import com.RokuEng.les4.core.domain.trait.Race;
import lombok.Getter;

public interface Human extends Race {
	Ability race = u -> {
		u.applyToHp(30);
	};
}
