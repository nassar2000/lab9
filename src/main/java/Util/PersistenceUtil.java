package Util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class PersistenceUtil {

  public  EntityManagerFactory emfactory;
    public PersistenceUtil() {}
    /*aici am creat un obiect ca sa ma ajuta sa relalizez conexiunea
    la sql server si detalile de conexinu sunt in persistence.xml  */
   public void createEntityManagerFactory(){
       emfactory = Persistence.createEntityManagerFactory( "MusicAlbumsPU" );

   }

   public  EntityManagerFactory returnEntityManagerFactory(){
       return emfactory;
   }
}
