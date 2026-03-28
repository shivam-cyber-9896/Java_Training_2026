package com.shivam.monocept.sorted.test;

import java.util.Comparator;
import java.util.List;

public class NamesAccToLen {
public static void main(String[] argus)
{List<String> names = List.of("Riya", "Arun", "Neha", "Karan","Anu");
names.stream()

.sorted(Comparator.comparing(String::length) )
.forEach(System.out::println);

	}
}
