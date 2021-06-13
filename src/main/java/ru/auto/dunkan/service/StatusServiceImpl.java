package ru.auto.dunkan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.auto.dunkan.entity.Status;
import ru.auto.dunkan.repository.StatusRepository;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;

    @Autowired
    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public Status getById(Long id) {
        return statusRepository.findById(id).get();
    }

    @Override
    public void save(Status status) {
        statusRepository.save(status);
    }

    @Override
    public void delete(Status status) {
        statusRepository.delete(status);
    }

    @Override
    public List<Status> getAll() {
        return statusRepository.findAll();
    }
}
