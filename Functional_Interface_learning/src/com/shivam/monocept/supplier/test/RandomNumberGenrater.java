package com.shivam.monocept.supplier.test;

import java.util.function.Supplier;

public class RandomNumberGenrater {

	public static void main(String[] args) {
		Supplier<Double> Genrater=()  -> Math.random()*10;
		System.out.println(Genrater.get());

	}

}
