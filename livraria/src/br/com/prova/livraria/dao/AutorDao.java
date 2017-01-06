package br.com.prova.livraria.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import br.com.prova.livraria.modelo.Autor;
import br.com.prova.livraria.modelo.Livro;

public class AutorDao {

	public static ArrayList<Autor> LSAutor = new ArrayList<Autor>();

	public void pesist(Autor autor) {
		LSAutor.add(autor);
	}

	public void drop() {
		// TODO Auto-generated method stub
		LSAutor.clear();
	}

	public List<Autor> listaTodos() {
		// TODO Auto-generated method stub
		return LSAutor;
	}

	public Autor buscaPorId(Integer autorId) {

		// TODO Auto-generated method stub
		for (Autor autor : LSAutor) {
			if (autorId == autor.getId()) {
				return autor;
			}
		}

		return null;

	}

	public void remove(Autor autor) {
		for (ListIterator<Autor> itr = LSAutor.listIterator(); itr.hasNext();) {
			Autor a = itr.next();
			if (a.getId().equals(autor.getId())) {
				itr.remove();
			}
		}
	}

	public void adiciona(Autor autor) {
		// TODO Auto-generated method stub

	}

	public void atualiza(Autor autor) {
		// TODO Auto-generated method stub

	}
}
