package br.com.prova.livraria.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import br.com.prova.livraria.modelo.Autor;
import br.com.prova.livraria.modelo.Livro;

public class LivroDao {

	public static ArrayList<Livro> LSLivro = new ArrayList<Livro>();
	
	
	public void pesist(Livro livro){
		LSLivro.add(livro);
	}


	public void drop() {
		// TODO Auto-generated method stub
		LSLivro.clear();
	}


	public List<Livro> listaTodos() {
		// TODO Auto-generated method stub
		return LSLivro;
	}


	public Livro buscaPorId(Integer id) {
		// TODO Auto-generated method stub
		for (Livro livro : LSLivro) {
			if(id == livro.getId()){
				return livro;
							
			}
		}
		
		return null;
	}


	public void adiciona(Livro livro) {
		LSLivro.add(livro);
		
	}


	public void atualiza(Livro livro) {
		for (Livro l : LSLivro) {
			if(livro.getId() == l.getId()){
				
				l.setTitulo(livro.getTitulo());			
			}
		}
	}


	public void remove(Livro livro) {
		for (ListIterator<Livro> itr = LSLivro.listIterator(); itr.hasNext();) {
			Livro a = itr.next();
			if (a.getIsbn().equals(livro.getIsbn())) {
				itr.remove();
			}
		}
		
	}
}
