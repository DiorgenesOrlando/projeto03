package projeto03;

import java.io.IOException;

public class PopularTabela {
	int ct[];
	int tabela[][];
	
	public PopularTabela(int[] ct, int[][] tabela) {
		super();
		this.ct = ct;
		this.tabela = tabela;
	}
	public  void adicionarCt() throws Exception {
		System.out.println("TABELA");
		for(int x = 0; x < ct.length; x++) {
			tabela[x][3] = ct[x];
			//System.out.println(tabela[x][0]+" "+tabela[x][1]+" "+tabela[x][2]+" "+tabela[x][3] );
		
		}
		adicionarTatEWt();
	}
	public  void adicionarTatEWt() throws Exception {
		System.out.println("TABELA");
		for(int x = 0; x < ct.length; x++) {
			tabela[x][4] = tabela[x][3] - tabela[x][1];
			tabela[x][5] = tabela[x][4] - tabela[x][2];
			System.out.println(tabela[x][0]+" "+tabela[x][1]+" "+tabela[x][2]+" "+tabela[x][3]+" "+tabela[x][4]+" "+tabela[x][5] );
		}
		LeitorArquivo.escritorInteiro(tabela);
		
	}
	
	
}
