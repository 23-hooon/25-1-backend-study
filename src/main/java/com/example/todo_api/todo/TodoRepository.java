package com.example.todo_api.todo;

import com.example.todo_api.member.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Todo todo){
        em.persist(todo);
    }

    public Todo find(Long id){
        return em.find(Todo.class, id);
    }

    public List<Todo> findAll(){
        return em.createQuery("select t from Todo as t", Todo.class)
                .getResultList();
    }

    public List<Todo> findAllByUser(Member member){
        return em.createQuery("select * from Todo t where t.member = :member", Todo.class)
                .setParameter("member",member)
                .getResultList();
    }

    public void remove(Long id){
        Todo todo = em.find(Todo.class, id);
        em.remove(todo);
    }
}
