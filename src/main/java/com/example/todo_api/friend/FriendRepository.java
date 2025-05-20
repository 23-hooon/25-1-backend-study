package com.example.todo_api.friend;

import com.example.todo_api.member.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FriendRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Friend friend){
        em.persist(friend);
    }

    public Friend find(Long id){
        return em.find(Friend.class, id);
    }

    public List<Friend> findAll(){
        return em.createQuery("select t from Todo as t", Friend.class)
                .getResultList();
    }

    public List<Friend> findAllByUser(Member member){
        return em.createQuery("select * from Friend f where f.member = :member", Friend.class)
                .setParameter("member",member)
                .getResultList();
    }

    public void remove(Long id){
        Friend friend = em.find(Friend.class, id);
        em.remove(friend);
    }
}
