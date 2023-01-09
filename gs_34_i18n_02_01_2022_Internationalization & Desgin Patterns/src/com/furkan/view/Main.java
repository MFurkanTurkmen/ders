package com.furkan.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

	public static void main(String[] args) {
		System.out.println("Türkçe: ---> ");
		ResourceBundle resourceBundle= ResourceBundle.getBundle("com/furkan/config/resource_bundle");
		System.out.println(resourceBundle.getString("word1")+" : "+resourceBundle.getString("language"));
		
		System.out.println("en: ---> ");
		Locale.setDefault(new Locale("en","EN"));
		 resourceBundle= ResourceBundle.getBundle("com/furkan/config/resource_bundle");
		System.out.println(resourceBundle.getString("word1")+" : "+resourceBundle.getString("language"));
		
		System.out.println("fr: ---> ");
		Locale.setDefault(new Locale("fr","FR"));
		 resourceBundle= ResourceBundle.getBundle("com/furkan/config/resource_bundle");
		System.out.println(resourceBundle.getString("word1")+" : "+resourceBundle.getString("language"));
	}

}
