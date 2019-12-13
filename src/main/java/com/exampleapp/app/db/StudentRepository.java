package com.exampleapp.app.db;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentRow,Long>
{
}
