package fr.maboite.webshop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionMain {

	public static void main(String[] args) {

		Set<String> phrases = new HashSet<String>();

		phrases.add("Salut !");
		phrases.add("Ca va ?");
		phrases.add("Ca va Bien");
		phrases.add("Ca va pas mal");
		phrases.add("Ca va moins bien");

		System.out.println("J'affiche tous les éléments de mon Set");
		for (String string : phrases) {
			System.out.println(string);
		}

		if (phrases.contains("Salut !")) {
			System.out.println("La phrase Salut est dans le Set");
		}

		phrases.remove("Salut !");
		if (phrases.contains("Salut !")) {
			System.out.println("La phrase Salut est dans le Set");
		} else {
			System.out.println("La phrase Salut est partie");
		}

		List<String> phrasesList = new ArrayList<String>();
		phrasesList.add("Coucou ! ");
		phrasesList.add(0, "Ca va bien");
		phrasesList.add("AAAaa ");

		System.out.println("J'affiche tous les éléments de ma List");
		for (String string : phrasesList) {
			System.out.println(string);
		}

		Collections.sort(phrasesList);
		System.out.println("J'affiche tous les éléments de ma List triés");
		for (String string : phrasesList) {
			System.out.println(string);
		}

	}

}
