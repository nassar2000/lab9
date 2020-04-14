package Repo;

import Entity.AlbumsEntity;
import Entity.ArtistsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class ArtistRepository {

    private EntityManagerFactory entityManagerFactory;

    public ArtistRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    public void create(ArtistsEntity artist){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public List<AlbumsEntity> findById (int id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query=entityManager.createQuery("select artist from ArtistsEntity artist where artist.id="+id);
        List<AlbumsEntity> artist =  query.getResultList();
        entityManager.close();
        return artist;
    }
    public List<AlbumsEntity> findByName(String name){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query=entityManager.createQuery("select artist from ArtistsEntity artist where artist.name="+name);
        List<AlbumsEntity> artist2 =  query.getResultList();
        entityManager.close();
        return artist2;

    }

}