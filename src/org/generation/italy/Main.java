package org.generation.italy;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int nrProdotti;
		Scanner sc=new Scanner(System.in);
		System.out.print("Benvenuto nel nostro negozio. Quanti prodotti vuoi inserire? ");
		nrProdotti=sc.nextInt();
		sc.nextLine();
		
		//dichiarazione variabili
		String[] prodotti=new String[nrProdotti];
		double[] prezzi=new double[nrProdotti];
		int[] quantità=new int[nrProdotti];
		int i,qta;
		String daAcquistare, risposta;
		double totale;
		boolean trovato;
		
		for (i=0;i<nrProdotti;i++) {
			System.out.println("Inserisci il prodotto nr " + i);
			System.out.print("Nome: ");
			prodotti[i]=sc.nextLine();
			
			System.out.print("Prezzo: ");
			prezzi[i]=sc.nextDouble();
			sc.nextLine();
			
			System.out.print("Quantità: ");
			quantità[i]=sc.nextInt();
			sc.nextLine();
			
		}
		
		totale=0;
		do {
			System.out.print("Che prodotto vuoi acquistare? ");
			daAcquistare=sc.nextLine();
			trovato=false;
			for (i=0;i<nrProdotti;i++)
				if (prodotti[i].toLowerCase().indexOf(daAcquistare.toLowerCase())>=0) {
					trovato=true;
					System.out.println("Prezzo: "+prezzi[i]);
					System.out.print("Inserisci la quantità: ");
					qta=sc.nextInt();
					sc.nextLine();
					
					if(qta<=quantità[i]) {
						System.out.println("Acquisto effettuato: "+ prezzi[i]*qta);
						quantità[i]-=qta;	//quantità[i]=quantità[i]-qta;
						totale+=prezzi[i]*qta;
					} else
						System.out.println("Quantità non sufficiente");
					
				}
			if (!trovato)
				System.out.println("Prodotto non disponibile");
			System.out.print("Vuoi acquistare un altro prodotto (s/n)?");
			risposta=sc.nextLine();
		} while(risposta.equalsIgnoreCase("s"));
		System.out.println("Il totale è " + totale);
	}

}
