package com.example.ldv.repository.hibernate;

import com.example.ldv.domain.Vote;
import com.example.ldv.repository.VoteRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public class VoteHibernateRepository implements VoteRepository {
    private SessionFactory sessionFactory;


    @Autowired
    public VoteHibernateRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession(){

        return sessionFactory.getCurrentSession();
    }

    @Override
    public boolean delete(Long id) {
        return currentSession().createNamedQuery(Vote.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public boolean save(Vote vote) {
        currentSession().saveOrUpdate(vote);
        return currentSession().load(Vote.class, vote.getId()).equals(vote);
    }

    @Override
    public List<Vote> findByDate(LocalDate date) {
        return currentSession().createNamedQuery(Vote.GET_VOTES_BY_DATE, Vote.class)
                .setParameter("date", date)
                .getResultList();
    }

    @Override
    public List<Vote> findByUser(Long userId) {
        return currentSession().createNamedQuery(Vote.GET_VOTES_BY_USER, Vote.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public Vote findByUserAndDate(Long userId, LocalDate date) {
        List<Vote> list = currentSession().createNamedQuery(Vote.GET_BY_USER_DATE, Vote.class)
                .setParameter("userId", userId)
                .setParameter("date", date)
                .getResultList();
        return DataAccessUtils.singleResult(list);
    }
}
