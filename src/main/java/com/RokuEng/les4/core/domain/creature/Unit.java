package com.RokuEng.les4.core.domain.creature;

import com.RokuEng.les4.core.domain.actions.Ability;
import com.RokuEng.les4.core.domain.creature.hero.Hero;
import com.RokuEng.les4.core.domain.item.armor.Protectable;
import com.RokuEng.les4.core.domain.item.trinket.Applyable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract  class Unit {

	@Getter
	@Setter
	private int hp;
	private String killer;

	@Getter
	private final List<Protectable> protectables = new ArrayList<>();
	@Getter
	private final List<Applyable> applyables = new ArrayList<>();

	public Unit(int hp) {
		this.hp = hp;
	}

	abstract public void damage(Unit fromTarget, Ability action);

	abstract public void apply(Ability action);

	abstract public void attack(Unit unit);

	public void death(Unit enemy) {
		System.out.printf("Персонаж мёртв! Убийца: %s! ", enemy.getClass().getSimpleName());
		enemy.addProtectables(this.getProtectables());
		protectables.clear();
		enemy.addApplyables(this.getApplyables());
		applyables.clear();

		if (enemy instanceof Hero) {
			((Hero) enemy).updateLvl();
		}
	}

	public boolean isDeath() {
		return hp <= 0;
	}

	public void applyToHp(int value) {
		this.hp += value;
	}

	public void addProtectables(Protectable... protectables) {
		Arrays.stream(protectables).forEach(protectable -> {
			System.out.printf("<%s> %s добавлен в инвентарь! ", this.getClass().getSimpleName(), protectable.getClass().getSimpleName());
		});
		this.protectables.addAll(List.of(protectables));
	}

	public void addProtectables(List<Protectable> protectables) {
		protectables.forEach(protectable -> {
			System.out.printf("<%s> %s добавлен в инвентарь! ", this.getClass().getSimpleName(), protectable.getClass().getSimpleName());
		});
		this.protectables.addAll(protectables);
	}

	public void addApplyables(Applyable... applyables) {
		Arrays.stream(applyables).forEach(applyable -> {
			System.out.printf("<%s> %s добавлен в инвентарь! ", this.getClass().getSimpleName(), applyable.getClass().getSimpleName());
		});
		this.applyables.addAll(List.of(applyables));
	}

	public void addApplyables(List<Applyable> applyables) {
		applyables.forEach(applyable -> {
			System.out.printf("<%s> %s добавлен в инвентарь! ", this.getClass().getSimpleName(), applyable.getClass().getSimpleName());
		});
		this.applyables.addAll(applyables);
	}
}
