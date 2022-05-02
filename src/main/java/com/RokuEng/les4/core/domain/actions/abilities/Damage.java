package com.RokuEng.les4.core.domain.actions.abilities;

import com.RokuEng.les4.core.domain.actions.Ability;
import com.RokuEng.les4.core.domain.creature.Unit;
import com.RokuEng.les4.core.domain.item.armor.Protectable;

public class Damage implements Ability {

	private int damage;

	public Damage(int damage) {
		this.damage = damage;
	}

	@Override
	public void apply(Unit unit) {

		int armor = unit.getProtectables().stream().mapToInt(Protectable::getArmor).sum();

		if (damage > armor) {
			int toHp = damage - armor;
			unit.applyToHp(-1 * toHp);
			System.out.printf("Нанёс %d урона! ", toHp, unit.getHp());
		} else {
			System.out.printf("<%s> Защитился! ", unit.getClass().getSimpleName());
		}
	}
}
