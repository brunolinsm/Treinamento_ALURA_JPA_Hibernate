package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;

import br.com.alura.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi", "Legal", new BigDecimal("800"), celulares);

        EntityManager em = JPAUtil.getEntityManager();
//        ProdutoDao produtoDao = new ProdutoDao(em);
//        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();
        em.persist(celulares);
        celulares.setNome("novo");
//        produtoDao.cadastrar(celular);
//        categoriaDao.cadastrar(celulares);
//        em.getTransaction().commit();
        em.flush();
        em.clear(); // Limpa o contexto de persistência
        
        celulares = em.merge(celulares); // Atualiza a categoria no contexto de persistência
        celulares.setNome("CELULARES NOVOS");
        em.flush();
//        em.close();
    }
}
