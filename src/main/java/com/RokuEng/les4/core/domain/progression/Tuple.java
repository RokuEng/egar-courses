package com.RokuEng.les4.core.domain.progression;

import lombok.Getter;

@Getter
public class Tuple {
    private final float hpMultiplayer;
    private final float damageMultiplayer;

    public Tuple(float hpMultiplayer, float damageMultiplayer) {
        this.hpMultiplayer = hpMultiplayer;
        this.damageMultiplayer = damageMultiplayer;
    }
}
