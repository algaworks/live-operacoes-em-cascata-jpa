package com.algaworks.sistemacursos;

import com.algaworks.sistemacursos.model.Aluno;
import com.algaworks.sistemacursos.model.Curso;
import com.algaworks.sistemacursos.model.Modulo;

import javax.persistence.*;
import java.util.Arrays;

public class OperacoesEmCascata {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("Cursos-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        gravacaoEmCascata(entityManager);
//        gravacaoEmCascataUpdate(entityManager);
//        gravacaoEmCascataManyToMany(entityManager);
//        exclusaoEmCascata(entityManager);
//        exclusaoEmCascataComManyToMany(entityManager);
        exclusaoEmCascataRemovendoOrfaos(entityManager);

        entityManager.close();
        entityManagerFactory.close();
    }

    public static void gravacaoEmCascata(EntityManager entityManager) {
        Curso curso = new Curso();
        curso.setNome("Especialista Spring REST");

        Modulo modulo = new Modulo();
        modulo.setNome("Introdução ao Spring");
        modulo.setCurso(curso);

        curso.setModulos(Arrays.asList(modulo));

        entityManager.getTransaction().begin();
        entityManager.persist(curso);
//        entityManager.persist(modulo);
        entityManager.getTransaction().commit();
    }

    public static void gravacaoEmCascataUpdate(EntityManager entityManager) {
        Curso curso = new Curso();
        curso.setId(1);
        curso.setNome("Especialista JPA");

        Modulo modulo = new Modulo();
        modulo.setId(1);
        modulo.setNome("Nome alterado");
        modulo.setCurso(curso);

        curso.setModulos(Arrays.asList(modulo));

        entityManager.getTransaction().begin();
        entityManager.merge(curso);
        entityManager.getTransaction().commit();
    }

    public static void gravacaoEmCascataManyToMany(EntityManager entityManager) {
        Curso curso = new Curso();
        curso.setNome("Especialista Spring REST");

        Aluno aluno = new Aluno();
        aluno.setNome("Maria Carla");

        curso.setAlunos(Arrays.asList(aluno));

        entityManager.getTransaction().begin();
        entityManager.persist(curso);
//        entityManager.persist(aluno);
        entityManager.getTransaction().commit();
    }

    public static void exclusaoEmCascata(EntityManager entityManager) {
        Modulo modulo = entityManager.find(Modulo.class, 1);

        entityManager.getTransaction().begin();

//        modulo.getAulas().forEach(a -> entityManager.remove(a));
        entityManager.remove(modulo);

        entityManager.getTransaction().commit();
    }

    public static void exclusaoEmCascataComManyToMany(EntityManager entityManager) {
        entityManager.getTransaction().begin();

        Curso curso = entityManager.find(Curso.class, 1);
        entityManager.merge(curso);

        entityManager.getTransaction().commit();
    }

    public static void exclusaoEmCascataRemovendoOrfaos(EntityManager entityManager) {
        entityManager.getTransaction().begin();

        Modulo modulo = entityManager.find(Modulo.class, 1);
        entityManager.remove(modulo);

        entityManager.getTransaction().commit();
    }
}
