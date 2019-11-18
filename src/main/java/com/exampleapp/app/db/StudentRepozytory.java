package com.exampleapp.app.db;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepozytory extends CrudRepository<StudentRow,Long>
{
}
