package ru.auto.dunkan.service;

import ru.auto.dunkan.entity.Status;

import java.util.List;

public interface StatusService {

    Status getById(Long id);

    void save(Status status);

    void delete(Status status);

    List<Status> getAll();
}
