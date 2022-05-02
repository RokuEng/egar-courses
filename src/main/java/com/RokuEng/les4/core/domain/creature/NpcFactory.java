package com.RokuEng.les4.core.domain.creature;

import com.RokuEng.les4.core.domain.creature.npc.Npc;
import com.RokuEng.les4.core.domain.creature.npc.Slime;
import lombok.experimental.UtilityClass;

@UtilityClass
public class NpcFactory {
	public Npc getSlime() {
		return new Slime(1);
	}
}
