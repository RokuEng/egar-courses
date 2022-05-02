package com.RokuEng.les4.core.domain.creature.hero;

import com.RokuEng.les4.core.domain.actions.Ability;
import com.RokuEng.les4.core.domain.actions.AbilityFactory;
import com.RokuEng.les4.core.domain.creature.Unit;
import com.RokuEng.les4.core.domain.item.armor.Protectable;
import com.RokuEng.les4.core.domain.trait.race.Human;

public class Guard extends Hero implements Human {

	public Guard(int hp) {
		super(hp);
	}

	@Override
	public void attack(Unit unit) {
		if (unit.isDeath()) {
			System.out.printf("<%s> %s уже мёртв! ", this.getClass().getSimpleName(), unit.getClass().getSimpleName());
			return;
		}

		System.out.printf("<%s> Атакую %s своим клинком! ", this.getClass().getSimpleName(), unit.getClass().getSimpleName());
		super.attack(unit);

		unit.damage(this,AbilityFactory.getLunge(50));
	}

	@Override
	public void death(Unit enemy) {
		levelAbility(enemy);
		if (isDeath()) {
			super.death(enemy);
		}
	}

	@Override
	void levelAbility(Unit enemy) {
		switch (Level.getFromOrdinal(lvl)) {
			case BASIC:
				this.apply(Level.BASIC.ability);
				break;
			case ADVANCED:
				this.apply(Level.ADVANCED.ability);
				break;
			case PROFESSIONAL:
				this.apply(Level.PROFESSIONAL.ability);
				break;
			case MASTER:
				this.apply(Level.MASTER.ability);
				break;
		}
	}

	@Override
	public void onAttack(Unit enemy) {
		System.out.printf("\"Хо-Хо! Я рыцарь чести!\" ");
	}

	@Override
	public void onProtect(Unit protectFrom) {
		getProtectables()
			.stream()
			.map(Protectable::protect)
			.forEach(ability -> ability.applyTo(this))
		;
	}

	@Override
	public void applyRace() {
		apply(race);
	}

	enum Level {
		BASIC(u -> {}),
		ADVANCED(u -> {
			int hp = 10;
			System.out.printf("Рыцарская доблесть! Восстановлено %d ХП! ", hp);
			u.applyToHp(hp);
		}),
		PROFESSIONAL(u -> {
			int hp = 30;
			System.out.printf("Кодекс чести! Восстановлено %d ХП! ", hp);
			u.applyToHp(hp);
		}),
		MASTER(u -> {
			int hp = 100;
			System.out.printf("Пламя Феникса! Персонаж воскрешён! Осталось %d ХП! ", hp);
			u.setHp(hp);
		})
		;

		Ability ability;

		Level(Ability ability) {
			this.ability = ability;
		}

		public static Level getFromOrdinal(int ordinal) {
			if (ordinal >= Level.values().length) {
				return Level.values()[values().length-1];
			}
			return Level.values()[ordinal];
		}
	}
}
