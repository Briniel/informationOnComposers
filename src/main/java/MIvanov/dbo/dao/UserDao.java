package MIvanov.dbo.dao;


import MIvanov.dbo.Table.ArtistTable;
import MIvanov.dbo.Utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by IvaMA on 02.03.2019
 */


public class UserDao {

    public ArtistTable findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(ArtistTable.class, id);
    }

    public void save(ArtistTable artist) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(artist);
        tx1.commit();
        session.close();
    }

    public void update(ArtistTable artist) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(artist);
        tx1.commit();
        session.close();
    }

    public void delete(ArtistTable artist) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(artist);
        tx1.commit();
        session.close();
    }

    public List<ArtistTable> findAll() {
        List<ArtistTable> artist = (List<ArtistTable>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Artist").list();
        return artist;
    }
}
