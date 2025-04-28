package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Categoria;
import jakarta.persistence.EntityManager;

public class CategoriaDao {

    private EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Categoria categoria) {
        this.em.persist(categoria);
    }

    public void atualizar(Categoria categoria) {
        this.em.merge(categoria);
    }

    public void remover(Categoria categoria) {
        categoria = em.merge(categoria); // Sincroniza o estado da categoria com o contexto de persistência
        this.em.remove(categoria);
    }
}
