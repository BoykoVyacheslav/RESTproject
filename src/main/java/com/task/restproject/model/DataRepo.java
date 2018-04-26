package com.task.restproject.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepo extends JpaRepository<Data,Integer> {
    Data findDataByIde(Integer id);
}
