package projeto03;

import java.util.Arrays;

public class Escalonador {
	String array[][];
	String algoritmo;
	int tamanhoArray;
	int quantidadeProcessos;

	public Escalonador(String[][] array, int tamanhoArray) {
		super();
		this.array = array;
		this.tamanhoArray = tamanhoArray;
		this.algoritmo = this.array[1][0];
		this.quantidadeProcessos = Integer.valueOf(this.array[0][0]);
	}

	public void definirEscalonador() throws Exception {
		if (algoritmo.equalsIgnoreCase("FCFS")) {
			System.out.println("FCFS");
			Fcfs fcfs = new Fcfs(array, tamanhoArray);
			// Arrays.sort(array[]);
			fcfs.gerarGrafico();
			System.out.println("Grafico Gantt - FCFS");
			fcfs.imprimirGrafico();

		} else if (algoritmo.equalsIgnoreCase("SJF")) {

		} else if (algoritmo.equalsIgnoreCase("RR")) {
			System.out.println("RR");
			Rr rr = new Rr(array, tamanhoArray);
			// Arrays.sort(array[]);
			rr.gerarGrafico();
			System.out.println("Grafico Gantt - FCFS");
			rr.imprimirGrafico();
		} else {
			System.out.println("Valor invalido para o Algoritmo, tente novamente");
		}

	}
}
