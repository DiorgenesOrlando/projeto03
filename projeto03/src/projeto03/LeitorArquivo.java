package projeto03;

import java.io.BufferedReader;
import java.io.File;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeitorArquivo {

	static String pathEntrada = "C:\\projeto03\\fileEntrada.txt";
	static String pathSaida = "C:\\projeto03\\fileSaida.txt";
	static List<String> arquivo = new ArrayList<String>();
	static List<String> arquivoSaida = new ArrayList<String>();
	static String[][] array;
	static float mediaSistema = 0;
	static float mediaTempo = 0;
	public static String[][] leitor() throws IOException {
		File file = new File(pathEntrada);
		Scanner in = new Scanner(file);

		int x =0;
		while(in.hasNext()){
			String entrada;			
			entrada = in.nextLine();
			arquivo.add(entrada);
			//System.out.println(entrada);

		};
		//System.out.println("tamanho da lista = "+arquivo.size());
		array = new String [arquivo.size()][6];

		for(int linha = 0; linha< arquivo.size(); linha++) {
			String  linhaAux = arquivo.get(linha);
			String auxiliar[] = new String[6];
			auxiliar = linhaAux.split(" ");
			for(int coluna = 0; coluna < auxiliar.length; coluna ++) {
				array[linha][coluna] = auxiliar[coluna];
			}
		}
		return array;
	}
	public static String[][] leitorSaida() throws IOException {
		File file = new File(pathSaida);
		Scanner in = new Scanner(file);

		int x =0;
		while(in.hasNext()){
			String entrada;			
			entrada = in.nextLine();
			arquivoSaida.add(entrada);
			//System.out.println(entrada);

		};
		//System.out.println("tamanho da lista = "+arquivo.size());
		array = new String [arquivo.size()-2][6];

		for(int linha = 0; linha< arquivo.size()-2; linha++) {
			String  linhaAux = arquivoSaida.get(linha);
			String auxiliar[] = new String[6];
			auxiliar = linhaAux.split(" ");
			System.out.println("Linha "+ linha);
			for(int coluna = 0; coluna <6; coluna ++) {
				System.out.println("Coluna "+ coluna);
				if(auxiliar[coluna] != null) {
					
				array[linha][coluna] = auxiliar[coluna];
				}
			}
		}
		return array;
	}

	public static void escritor(String string[][]) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(pathSaida));
		Scanner in = new Scanner(System.in);

		int y = 0;

		for(int x = 0; x <arquivo.size(); x++) {

			while(y<6){
				if(string[x][y] != null) {

					buffWrite.append(string[x][y] +" ");
					buffWrite.flush();
					//System.out.println(string[x][y]);
				}


				y++;
			}
			y=0;
			buffWrite.append("\n");
		}
		buffWrite.close();
	}

	public static void escritorInteiro(int string[][]) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(pathSaida));
		Scanner in = new Scanner(System.in);
		

		int y = 0;

		for(int x = 0; x <arquivo.size() -2; x++) {

			while(y<6){
				buffWrite.append(string[x][y] +" ");
				if(y == 4) {
					
					mediaSistema = mediaSistema + string[x][4];
				}
				if(y == 5) {
 					mediaTempo = mediaTempo + string[x][5];
				}
				buffWrite.flush();
				y++;
			}
			y=0;
			buffWrite.append("\n");
		}
		mediaSistema = mediaSistema / (arquivo.size()-2);
		mediaTempo = mediaTempo / (arquivo.size()-2);
		

		buffWrite.close();
	}

	public static void escritorGraficoGantt(String string[][]) throws IOException {
		String [][] arquivoBackup = LeitorArquivo.leitorSaida();
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(pathSaida));
		int y = 0;
		buffWrite.append("ID AT BT CT TAT WT\n");

		for(int x = 0; x <arquivoBackup.length; x++) {

			while(y<6){
				buffWrite.append(arquivoBackup[x][y] +" ");
				y++;
			}
			y=0;
			buffWrite.append("\n");

		}
		buffWrite.append("\n      GRAFICO DE GANTT\n");
		for(int x = 0; x <arquivo.size() -2; x++) {

			while(y<1){
				buffWrite.append(string[x][0] +" ");
				buffWrite.flush();
				y++;
			}
			y=0;
		}
		buffWrite.append("\n");
		y=0;
		for(int x = 0; x <arquivo.size() -2; x++) {
			while(y<1){
				buffWrite.append(string[x][1] +" ");
				buffWrite.flush();
				y++;
			}
			y=0;
		}
		buffWrite.append("\nMedia Sistema : "+mediaSistema);
		buffWrite.flush();
		//buffWrite.append("\n");

		buffWrite.append("\nMedia Tempo : "+mediaTempo);
		buffWrite.flush();

		buffWrite.append("\n");
		buffWrite.close();
	}
}