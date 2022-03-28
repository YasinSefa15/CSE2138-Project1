package com.company;

public class Main {

	static InputController input;

	public static void main(String[] args) {
		input = new InputController();
		input.operate(input.read());
	}

}


