package ru.auto.dunkan.service;

import org.springframework.stereotype.Service;
import ru.auto.dunkan.model.Status;
import ru.auto.dunkan.repo.StatusRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service("statusService")
public class StatusService {

    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public StatusService(StatusRepository statusRepository) {

    }

    public Status getById(Long id) {
        return em.find(Status.class, id);
    }
}
