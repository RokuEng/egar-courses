package com.RokuEng.les4.core.domain.trait;

import com.RokuEng.les4.core.domain.creature.Unit;

public interface Profession {
	void onAttack(Unit enemy);
	void onProtect(Unit protectFrom);
}
