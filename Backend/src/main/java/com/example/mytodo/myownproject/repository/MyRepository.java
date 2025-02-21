package com.example.mytodo.myownproject.repository;

import com.example.mytodo.myownproject.modelentity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepository extends JpaRepository<ToDo,Long> {
// jap vachesi Gives us ready-made functions to save, delete, update, and find todos in the database.
}
