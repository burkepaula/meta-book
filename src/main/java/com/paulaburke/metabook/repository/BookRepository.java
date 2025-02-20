package com.paulaburke.metabook.repository;

import com.paulaburke.metabook.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
