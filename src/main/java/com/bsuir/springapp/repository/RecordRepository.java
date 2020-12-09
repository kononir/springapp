package com.bsuir.springapp.repository;

import com.bsuir.springapp.entity.RecordModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends CrudRepository<RecordModel, String> {
}
