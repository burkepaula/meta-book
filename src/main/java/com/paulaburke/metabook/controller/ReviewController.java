package com.paulaburke.metabook.controller;

import com.paulaburke.metabook.model.Review;
import com.paulaburke.metabook.model.Book;
import com.paulaburke.metabook.service.BookService;
import com.paulaburke.metabook.service.ReviewService;
import com.paulaburke.metabook.service.GoogleCloudService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final GoogleCloudService googleCloudService;
    private final BookService bookService;

    @Autowired
    public ReviewController(ReviewService reviewService, GoogleCloudService googleCloudService, BookService bookService) {
        this.reviewService = reviewService;
        this.googleCloudService = googleCloudService;
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Review> addReview(@Valid @RequestBody Review review) {
        Optional<Book> optionalBook = bookService.getBookById(review.getBook().getId());

        if (!optionalBook.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Book book = optionalBook.get();
        String generatedReview = googleCloudService.generateReview(book.getTitle());
        review.setReviewText(generatedReview);

        Review createdReview = reviewService.addReview(review);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReview);
    }
}