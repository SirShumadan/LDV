package com.example.ldv.repository.hibernate;

import com.example.ldv.domain.Vote;
import com.example.ldv.repository.VoteRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

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
        return false;
    }

    @Override
    public void save(Vote vote) {
        currentSession().saveOrUpdate(vote);
    }

    @Override
    public Vote findByDate(LocalDate date) {
        return null;
    }

    @Override
    public Vote findByUserId(Long userId) {
        return null;
    }

    @Override
    public Vote findByUserAndDate(Long userId, LocalDate date) {
        return null;
    }
}
