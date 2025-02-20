package com.paulaburke.metabook.repository;

import com.paulaburke.metabook.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
