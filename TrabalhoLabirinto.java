package labirinto;

import java.util.Scanner;

public class TrabalhoLabirinto {
	
	static String vertical = "|";
	static String horizontal = "-";
	static String vazio = ".";
	static int tamanho= 10;
	static int saida= tamanho-2;
	static String obstaculo = "#";
	static String boneco = "@";
	static int linha = 2;
	static int coluna = 1;
	static int contadorBonusI, contadorBonusF=0;
	static double probabilidade = 0.8;
	static String [] [] tabuleiro= new String [tamanho][tamanho];
	static Scanner sc= new Scanner(System.in);
	
	
	public static void GerarTabuleiro() {	
				
		for (int i=0; i<tamanho; i++) {
			tabuleiro [0] [i] = horizontal;
			tabuleiro [tamanho-1] [i] = horizontal;
			tabuleiro [i] [0] = vertical;
			tabuleiro [i] [tamanho-1] = vertical;
		}
				
		for (int i=1; i<tamanho-1; i++) {
			for (int j=1; j<tamanho-1; j++) {
				if (Math.random()>probabilidade) {
					tabuleiro [i] [j] = obstaculo;
				} else if (Math.random()>0.97){
					tabuleiro[i][j]= "$";
					contadorBonusI++;
				}else {
					tabuleiro [i] [j] = vazio;
				}
			}	
		}
		
	                		
		tabuleiro [1][1]= "P";
		tabuleiro [linha][coluna]= boneco;
		tabuleiro [tamanho-2][tamanho-2]="S";
	}
		
		
	public static void ImprimirTabuleiro() {
		for (int i=0; i<tamanho; i++) {
			for (int j=0; j<tamanho; j++) {
				System.out.print(tabuleiro [i][j]);
				
			}
			System.out.println();
		}
	}
	
	
	
	public static void movimentacao() {
		
		System.out.println("🚶 informe a quantidade de movimentos que deseja ");
		int quantMovimentos= sc.nextInt();
		int i= quantMovimentos;
		System.out.println("🗺️ informe a quantidade de vizualizações de mapa que deseja ");
		int quantVizu= sc.nextInt();
		int vizu= quantVizu;
		
		System.out.println("===MENU DE AÇÕES===:\n" + "1. Mover (↑W ↓S <A D> \n" + "2. Exibir labirinto (L) \n" + "3.Sair do Jogo (X)");
		
		while (i>0 && (coluna !=tamanho-2 || linha !=tamanho-2)) {
			int linhaAnterior = linha;
		    int colunaAnterior = coluna;
		    String mov=sc.next();
			if (mov.equalsIgnoreCase("S")) {
				linha++;
			} else if (mov.equalsIgnoreCase("w")){
				linha--;
			}else if (mov.equalsIgnoreCase("A")) {
				coluna--;
			}else if (mov.equalsIgnoreCase("D")) {
				coluna++;
			} else if (mov.equalsIgnoreCase("L") && vizu>0) {
                ImprimirTabuleiro();
                vizu--;
                continue; 
            } else if (mov.equalsIgnoreCase("L")){
            	System.out.println("🚫 você não pode mais vizualizar o tabuleiro");
            	continue;
            }else if (mov.equalsIgnoreCase("X")) {
                System.out.println("Saindo do jogo...");
                i = 0; 
                continue;
            } else {
            	System.out.println("🚫 movimento inválido");
            	continue;
            }
			if (linha < 1 || coluna < 1 || linha >= tamanho-1 || coluna >= tamanho-1) {
                System.out.println("🚫 Você bateu na borda do mapa! Movimento cancelado.");
                linha= linhaAnterior;
                coluna= colunaAnterior;
                continue;
                } 
                
			if (tabuleiro [linha] [coluna].equals(obstaculo)) {
				System.out.println("🚫 Você bateu no obstaculo do mapa! Movimento cancelado.");
                linha= linhaAnterior;
                coluna= colunaAnterior;
                continue; 
			}
			if (tabuleiro[linha][coluna].equals("$")) {
			    System.out.println("💰 Bônus coletado! +2 pontos!");
			    contadorBonusF++;
			}if (linhaAnterior == 1 && colunaAnterior == 1) {
				tabuleiro[linhaAnterior][colunaAnterior] = "P";
			}else {
			tabuleiro[linhaAnterior][colunaAnterior] = vazio; 
			}
			
		    tabuleiro[linha][coluna] = boneco;
		    if (coluna ==tamanho-2 && linha ==tamanho-2) {
            	System.out.println("====PARABÉNS! você ganhou o jogo :)====");
            	System.out.println("você usou " + (quantMovimentos-i) + " movimentos");
            	System.out.println("você usou " + (quantVizu-vizu) + " vizualizações de mapa");
          
            	int bonus= (contadorBonusI - contadorBonusF)*2;
            	System.out.println("💰 sua pontuação foi: " + (((quantMovimentos-i)+(quantVizu-vizu)*2)+ bonus ));
			i=0;} else {
				i--;
			 if ( i==0 && (coluna !=tamanho-2 || linha !=tamanho-2)) {
	            	System.out.println("===infelizmente, suas chances acabaram e você não completou o desafio :(===");
			    }
		}
		    }
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("=========BEM VINDOS AO LABIRINTO=========");
		int opcoesTamanho;
		System.out.println("INFORME O TAMANHO DE TABULEIRO QUE VOCÊ DESEJA:\n" + "[1] 10X10 (PADRÃO)\n" + "[2] 20X20\n"+ "[3] 30X30\n");
		opcoesTamanho=sc.nextInt();
		
		switch(opcoesTamanho) {
		
		case 1:
			tamanho=10;
			break;
		case 2:
			tamanho=20;
			break;
		case 3:
			tamanho=30;
			break;
		default:
			System.out.println("opção invalida, tamanho seguirá padrão");
		}
		
		tabuleiro = new String[tamanho][tamanho]; 
        saida = tamanho - 2;
		
		
		GerarTabuleiro();
		ImprimirTabuleiro();
		movimentacao();
		
		
				
		

		   
	}
}

