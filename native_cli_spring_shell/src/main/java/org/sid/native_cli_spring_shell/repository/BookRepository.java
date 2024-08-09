package org.sid.native_cli_spring_shell.repository;

import org.sid.native_cli_spring_shell.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
