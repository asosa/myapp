package com.asosa.myapp.domain;

import org.springframework.stereotype.Component;

@Component
public class Hashimoto implements Speakable {
	public String sayHello() {
		return "My name is hashimot";
	}
}
