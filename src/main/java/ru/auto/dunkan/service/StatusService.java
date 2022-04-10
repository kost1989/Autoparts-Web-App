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

    private final StatusRepository statusRepository;

    @Autowired
    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public Status getById(Long id) {
        return statusRepository.getById(id);
    }

    public List<Status> getListByFilter(Status status) {
        if (status.getName() == null) {
            return statusRepository.getListByFilter(status.getId(), null, status.getColor(), status.getEnabled());
        } else {
            return statusRepository.getListByFilter(status.getId(), status.getName().toLowerCase(), status.getColor(), status.getEnabled());
        }

    }

    public Status create(Status status) {
        status.setEnabled(true);
        if (statusRepository.getListByFilter(status.getId(), status.getName(), status.getColor(), status.getEnabled())
                .isEmpty()) {
            return statusRepository.saveAndFlush(status);
        } else {
            return statusRepository.getListByFilter(status.getId(), status.getName()
                    , status.getColor(), status.getEnabled()).get(0);
        }
    }

    public Status update(Status status) {
        return statusRepository.saveAndFlush(status);
    }

    public Status delete(Status status) {
        status.setEnabled(false);
        return statusRepository.saveAndFlush(status);
    }
}
