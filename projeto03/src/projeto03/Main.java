package projeto03;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws Exception {
	
		
		String arquivo[][] =LeitorArquivo.leitor();
		int tamanhoArray = LeitorArquivo.arquivo.size();
		Escalonador escalonador = new Escalonador(arquivo, tamanhoArray);
		escalonador.definirEscalonador();
	//	LeitorArquivo.escritor(arquivo);
	}
}
