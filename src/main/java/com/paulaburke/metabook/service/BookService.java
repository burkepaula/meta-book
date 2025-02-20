package com.paulaburke.metabook.service;

import com.paulaburke.metabook.model.Book;
import com.paulaburke.metabook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // Atualizar um livro
    public Optional<Book> updateBook(Long id, Book bookDetails) {
        return bookRepository.findById(id).map(existingBook -> {
            existingBook.setTitle(bookDetails.getTitle());
            existingBook.setAuthor(bookDetails.getAuthor());
            existingBook.setGenre(bookDetails.getGenre());
            existingBook.setDescription(bookDetails.getDescription());
            return bookRepository.save(existingBook);
        });
    }

    // Deletar um livro
    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id); // Retorna um Optional<Book>
    }

}
