package com.RokuEng.les4.core.domain.item;

import com.RokuEng.les4.core.domain.item.armor.Chestplate;
import com.RokuEng.les4.core.domain.item.armor.Protectable;
import com.RokuEng.les4.core.domain.item.trinket.Applyable;
import com.RokuEng.les4.core.domain.item.trinket.Healthstone;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ItemFactory {
	public Protectable getChestplate() {
		return new Chestplate();
	}

	public Applyable getHealthstone() {
		return new Healthstone();
	}
}
