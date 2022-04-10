package ru.auto.dunkan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.auto.dunkan.model.Supplier;
import ru.auto.dunkan.repo.SupplierRepository;

import java.util.List;

@Service
@Transactional
public class SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public Supplier getById(Long id) {
        return supplierRepository.getById(id);
    }

    public List<Supplier> getListByFilter(Supplier supplier) {
        return supplierRepository.getListByFilter(supplier.getId(), supplier.getName(), supplier.getUrl(),
                supplier.getComments(), supplier.getEnabled()); //TODO: я остановился тут. Нужно доделать запрос
    }
}
