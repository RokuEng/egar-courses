package com.RokuEng.springrest.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public enum BigDecimals {
	HUNDRED(BigDecimal.valueOf(100))
	;

	private final BigDecimal value;
}
