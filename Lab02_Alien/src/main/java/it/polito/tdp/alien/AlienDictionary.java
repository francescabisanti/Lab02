package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	private String alienWord;
	private String translation;
	 
	Map <String, List <String>> dizionario;
	List <String> multiple;
	public AlienDictionary() {
		dizionario= new TreeMap <String, List<String>>();
	}
	
	public void addWords(String alienWord, String translation) {
		multiple= new LinkedList <String>();
		
		if(dizionario.get(alienWord)!=null) {
			multiple= dizionario.get(alienWord);
			multiple.add(translation);
			dizionario.replace(alienWord, multiple);
		
		}
		else {
			
			multiple.add(translation);
			dizionario.put(alienWord, multiple);
		}
		
	}
	
	public String translate(String alienWord) {
		multiple= dizionario.get(alienWord);
		String risultato="";
		for(String s: multiple) {
			risultato=risultato+ s+"\n";
		}
		return risultato;
	}
	public void clearDictionary(){
		
			dizionario.clear();
		
	}

	

	
}
