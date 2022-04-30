package com.RokuEng.les4.core.domain.creature.npc;

import com.RokuEng.les4.core.domain.creature.Unit;
import com.RokuEng.les4.core.domain.trait.Race;

public abstract class Monster extends Unit implements Race {
	public Monster(int hp) {
		super(hp);
	}
}
