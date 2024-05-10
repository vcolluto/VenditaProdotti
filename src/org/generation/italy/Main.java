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
		int i,qta, pos=0;
		String daAcquistare, risposta;
		double totale;
		int nrTrovati;
		
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
			nrTrovati=0;
			for (i=0;i<nrProdotti;i++)
				if (prodotti[i].toLowerCase().indexOf(daAcquistare.toLowerCase())>=0) {
					 nrTrovati++;
					 pos=i;		//memorizzo la posizione
					
				}
			if (nrTrovati==0)
				System.out.println("Prodotto non disponibile");
			else if (nrTrovati==1) {		//ho trovato un solo prodotto => acquisto
				System.out.println("Prodotto trovato: "+prodotti[pos]);
				System.out.println("Prezzo: "+prezzi[pos]);
				System.out.print("Inserisci la quantità: ");
				qta=sc.nextInt();
				sc.nextLine();
				
				if(qta<=quantità[pos]) {
					System.out.println("Acquisto effettuato: "+ prezzi[pos]*qta);
					quantità[pos]-=qta;	//quantità[i]=quantità[i]-qta;
					totale+=prezzi[pos]*qta;
				} else
					System.out.println("Quantità non sufficiente");				
			} else	// ho trovato più di un prodotto
				System.out.println("E' stato trovato più di un prodotto, raffina la ricerca");
				
			System.out.print("Vuoi acquistare un altro prodotto (s/n)?");
			risposta=sc.nextLine();
		} while(risposta.equalsIgnoreCase("s"));
		System.out.println("Il totale è " + totale);
	}

}
