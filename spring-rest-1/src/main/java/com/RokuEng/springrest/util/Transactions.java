package com.RokuEng.springrest.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Transactions {
	public void transaction(Runnable function) {
		try {
			function.run();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
