package Repo;

import Entity.AlbumsEntity;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.*;
import java.util.List;

public class AlbumRepository {

    private EntityManagerFactory entityManagerFactory;

    public AlbumRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    public void create(AlbumsEntity album) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        /*aici marcam o coloana pt a putea face inserarea*/
        entityManager.persist(album);
        /*aici incepem inserarea*/
        entityManager.getTransaction().commit();
        /* aici inchid conexiunea */
        entityManager.close();
    }

    public List<AlbumsEntity> findById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        /*aici am executat comanda sql*/
        Query query = entityManager.createQuery("select album from AlbumsEntity album where album.id=" + id);
        /*aici sa stoceaza datele*/
        List<AlbumsEntity> albums = query.getResultList();
        /*aici sa inchide conexiunea*/
        entityManager.close();
        return albums;

    }

    public List<AlbumsEntity> findByName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select album from AlbumsEntity album where album.name=" + name);
        List<AlbumsEntity> albums = query.getResultList();
        entityManager.close();
        return albums;
    }

}
