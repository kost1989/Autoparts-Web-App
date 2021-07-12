package ru.auto.dunkan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.auto.dunkan.model.Status;
import ru.auto.dunkan.repo.StatusRepository;

import java.util.List;

@Service
@Transactional
public class StatusService {

    StatusRepository statusRepository;

    @Autowired
    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public void save(Status status) {
        statusRepository.save(status);
    }

    public List<Status> listAll() {
        return (List<Status>) statusRepository.findAll();
    }

    public Status get(Long id) {
        return statusRepository.findById(id).get();
    }

    public void delete(Long id) {
        statusRepository.deleteById(id);
    }
}
