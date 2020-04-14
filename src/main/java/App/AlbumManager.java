package App;

import Entity.AlbumsEntity;
import Entity.ArtistsEntity;
import Repo.AlbumRepository;
import Repo.ArtistRepository;
import Util.PersistenceUtil;


public class AlbumManager {

    public static void main (String args[])
    {

        PersistenceUtil prsu=new PersistenceUtil();

        prsu.createEntityManagerFactory();
        /* aici am creat un obiect de tip artistRepository care imi returneaza metoda din EntityManagerFactory */
        ArtistRepository art=new ArtistRepository(prsu.returnEntityManagerFactory());
        ArtistsEntity arte=new ArtistsEntity();
        arte.setCountry("SUA");
        arte.setName("Otis");
        /* aici am folosit create pt a ma putea conecta la baza de date si sa inserez datele  */
        art.create(arte);
        /* aici am creat un obiect de tip AlbumRepository*/
        AlbumRepository alb=new AlbumRepository(prsu.returnEntityManagerFactory());
        AlbumsEntity albe = new AlbumsEntity();
        albe.setArtistId(1);
        albe.setName("Casasda");
        albe.setReleaseYear(1964);
        alb.create(albe);

        System.out.println( alb.findById(1).get(0).toString());

    }
}
