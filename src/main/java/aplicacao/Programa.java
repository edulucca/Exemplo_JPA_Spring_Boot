package aplicacao;

import dominio.Pessoa;

public class Programa {
	public static void main(String[] args) {
		// instancia pessoas
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(2, "Joaquim Torres", "joaquim@gmail.com");
		Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
		
		//manda gravar pessoas
		p2.excluirPessoa();
		
	}
}
