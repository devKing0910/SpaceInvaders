package br.com.mvbos.lgj;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ranking {

    private ArrayList<Jogador> jogadores = new ArrayList<>();

    public void adicionar(Jogador jogador) {
        jogadores.add(jogador);
    }

    public void salvarRanking() throws IOException {
    	Collections.sort(jogadores);

        File arquivo = new File("C:\\Users\\Helano Franco\\Documents\\SpaceInvaders\\Ranking.txt");

        FileWriter escritor = new FileWriter(arquivo);

        for (Jogador jogador : jogadores) {
            escritor.write(jogador.getNome() + " " + jogador.getPontuacao() + "\n");
        }

        escritor.close();
        
        System.out.println("-------------------- RANKING --------------------");
        
        int totalJogadores = jogadores.size();
        int quantidadeExibida = Math.min(totalJogadores, 10);

        for (int i = 0; i < quantidadeExibida; i++) {
            Jogador jogador = jogadores.get(i);
            System.out.println("Jogador: " + jogador.getNome() + " | Pontuação: " + jogador.getPontuacao());
        }

    }

    public void carregarRanking() throws IOException {
    	File arquivo = new File("C:\\Users\\Helano Franco\\Documents\\SpaceInvaders\\Ranking.txt");

        Scanner scanner = new Scanner(arquivo);

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] dados = linha.split(" ");
            
            if (dados.length != 2) {
                System.out.println("Formato de linha inválido: " + linha);
                continue;
            }
            
            String nome = dados[0];
            int pontuacao;
            
            try {
                pontuacao = Integer.parseInt(dados[1]);
            } catch (NumberFormatException e) {
                System.out.println("Formato inválido para pontuação: " + dados[1]);
                continue;
            }

            Jogador jogador = new Jogador();
            jogador.setNome(nome);
            jogador.setPontuacao(pontuacao);

            jogadores.add(jogador);
        }

        scanner.close();
    }
}