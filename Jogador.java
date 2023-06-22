package br.com.mvbos.lgj;

public class Jogador implements Comparable<Jogador> {
    private String nome;
    private int pontuacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

	@Override
	public int compareTo(Jogador outroJogador) {
		if (this.getPontuacao() > outroJogador.getPontuacao()) {
			return -1;
		}
		
		if (this.getPontuacao() < outroJogador.getPontuacao()) {
			return 1;
		}
		
		return 0;
	}
}