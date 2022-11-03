package projeto03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fcfs extends Escalonador{
	int vetorAuxiliar[][];
	int [][] aux = new int [tamanhoArray-2][3];
	int [] auxChegada = new int [tamanhoArray-2];
	String [][] saidaGrafico = new String [tamanhoArray-2][2];


	public Fcfs(String[][] array, int tamanhoArray) {
		super(array, tamanhoArray);
		vetorAuxiliar = new int [tamanhoArray-2][6];
		// TODO Auto-generated constructor stub
	}
	// Ordena quais valores sao menores, definido quem chegou primeiro
	public void gerarGrafico() {
		int menorValor = 0;

		menorValor =Integer.valueOf(array[2][1]);
		for(int x = 2; x<super.tamanhoArray; x++ ) {
			aux[x-2][0] = Integer.valueOf(array[x][0]);
			aux[x-2][1] = Integer.valueOf(array[x][1]);
			aux[x-2][2] = Integer.valueOf(array[x][2]);
			auxChegada[x-2] = Integer.valueOf(array[x][1]);
		}
		Arrays.sort(auxChegada);


		for(int x = 2; x<super.tamanhoArray; x++ ) {		
			int x1 = x-2;
			//if(Integer.valueOf(array[x][1]) == aux[x-2]) {
			vetorAuxiliar[x1][0] = Integer.valueOf(array[x][0]);
			System.out.print(vetorAuxiliar[x1][0]);
			vetorAuxiliar[x1][1] = Integer.valueOf(array[x][1]);
			System.out.print(vetorAuxiliar[x1][1]);
			vetorAuxiliar[x1][2] = Integer.valueOf(array[x][2]);
			System.out.print(vetorAuxiliar[x1][2]);
			System.out.println();
		}
		//}

	}

	public void imprimirGrafico() {
		gerarGraficoGantt();
		saida();

	}
	private void gerarGraficoGantt() {
		int cont = 0;
		int auxiliar = 0;
		int tamanho=tamanhoArray-2;

		System.out.println("Tamanho de saidaGrafico "+saidaGrafico.length);
		System.out.println("Tamanho de tamanhoArray "+tamanhoArray);
		System.out.println("Tamanho de vetorAuxiliar "+vetorAuxiliar.length);
		boolean b = true;
		int finalExecucao = 0;
		int contX =0;

		do {
			for(int x = 0; x <tamanho; x++) {
				if(vetorAuxiliar[x][1] == auxChegada[cont]) {
					System.out.println("P"+vetorAuxiliar[x][0]);
					saidaGrafico[contX][0] = String.format(" P %d  |",vetorAuxiliar[x][0]);
					System.out.println(vetorAuxiliar[x][1]+vetorAuxiliar[x][2]);
					if(contX == 0) {
						finalExecucao = vetorAuxiliar[x][1]+vetorAuxiliar[x][2];
						saidaGrafico[contX][1] = String.format("    %d ", finalExecucao);
					}else {
						if(vetorAuxiliar[x][1] > finalExecucao) {
							int diferenca = vetorAuxiliar[x][1] - finalExecucao;
							finalExecucao += (diferenca);
							finalExecucao += vetorAuxiliar[x][2];	
							saidaGrafico[contX][1] = String.format("   %d ", finalExecucao);
						}else {
							finalExecucao += vetorAuxiliar[x][2];	
							saidaGrafico[contX][1] = String.format("    %d ", finalExecucao);
						}
					}

					contX++;
					if(cont < tamanho -1) {

						cont ++;
					}else if(cont == (tamanho-1)) {
						b = false;
					}
				}
			}

		}while(b == true);

	}
	public void saida() {
		for(int x=0; x<tamanhoArray-2; x++) {
			System.out.print(saidaGrafico[x][0]);
		}
		System.out.println();
		for(int x=0; x<tamanhoArray-2; x++) {
			System.out.print(" "+saidaGrafico[x][1]);
		}
	}
}