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
	static String[][] array;
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

}