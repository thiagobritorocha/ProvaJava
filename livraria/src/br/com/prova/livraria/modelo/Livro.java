package br.com.prova.livraria.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	private String titulo;
	private String isbn;
	private double preco;
	@Temporal(TemporalType.DATE)
	private Calendar dataLancamento = Calendar.getInstance();

	@ManyToMany(fetch=FetchType.EAGER)
	private List<Autor> autores = new ArrayList<Autor>();

	public List<Autor> getAutores() {
		return autores;
	}

	public void adicionaAutor(Autor autor) {
		for (ListIterator<Autor> itr = autores.listIterator(); itr.hasNext();) {
			Autor a = itr.next();
			if (a.getNome().equals(autor.getNome())) {
				throw new RuntimeException("N�o � poss�vel adicionar novamente o autor "+autor.getNome()+" !");
			}
		}
		this.autores.add(autor);
	}

	public Livro() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public void removeAutor(Autor autor) {
		this.autores.remove(autor);
	}

}