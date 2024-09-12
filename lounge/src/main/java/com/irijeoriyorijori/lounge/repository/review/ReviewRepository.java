package com.irijeoriyorijori.lounge.repository.review;

import com.irijeoriyorijori.lounge.domain.review.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//public interface ReviewRepository extends PagingAndSortingRepository<Review, String> {
////    List<Review> findAll(); // 모든 리뷰를 가져오는 메소드
//    Page<Review> findAll(Pageable pageable); // 페이지네이션을 지원하는 메소드
//
//
//
//}

//@Repository
//public interface ReviewRepository extends JpaRepository<Review, String> {
//
//    @Query(value = "SELECT * FROM ( " +
//            "SELECT review_id, content, created_at, updated_at, user_id, reservation_id, " +
//            "ROW_NUMBER() OVER (ORDER BY updated_at DESC) AS rn " +
//            "FROM review " +
//            ") WHERE rn >= :start AND rownum <= :end", nativeQuery = true)
//    List<Review> findReviewsWithPagination(@Param("start") int start, @Param("end") int end);
//
//    @Query(value = "SELECT COUNT(*) FROM review", nativeQuery = true)
//    long countReviews();
//}


@Repository
public interface ReviewRepository extends JpaRepository<Review, String> {

    @Query(value = "SELECT * FROM ( " +
            "SELECT review_id, content, created_at, updated_at, user_id, reservation_id, " +
            "ROW_NUMBER() OVER (ORDER BY updated_at DESC) AS rn " +
            "FROM review " +
            ") WHERE rn BETWEEN :start AND :end", nativeQuery = true)
    List<Review> findReviewsWithPagination(@Param("start") int start, @Param("end") int end);

    @Query(value = "SELECT COUNT(*) FROM review", nativeQuery = true)
    long countReviews();
}
