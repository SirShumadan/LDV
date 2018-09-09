package com.example.ldv.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NamedQueries({
        @NamedQuery(
                name = Vote.GET_BY_USER_DATE,
                query = "SELECT v FROM Vote v WHERE v.userId = :userId AND v.createdDate = :date"
        ),
        @NamedQuery(
                name = Vote.GET_VOTES_BY_DATE,
                query = "SELECT v FROM Vote v WHERE v.createdDate = :date"
        ),
        @NamedQuery(
                name = Vote.GET_VOTES_BY_USER,
                query = "SELECT v FROM Vote v WHERE v.userId = :userId"
        ),
        @NamedQuery(
                name = Vote.DELETE,
                query = "DELETE FROM Vote v WHERE v.id = :id"
        )
})
@Entity
@Table(name = "votes")
public class Vote {
    public static final String GET_VOTES_BY_USER = "Vote.getVotesByUser";
    public static final String GET_BY_USER_DATE = "Vote.getByUserDate";
    public static final String GET_VOTES_BY_DATE = "Vote.getVotesByDate";
    public static final String DELETE = "Vote.delete";


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "user_id")
    @NotNull
    private Long userId;

    @Column(name = "restaurant_id")
    @NotNull
    private Long restaurantId;

    @Column(name = "created")
    private LocalDate createdDate;

    public Vote() {
    }

    public Vote(Long id, long userId, long restaurantId, LocalDate createdDate) {
        this.id = id;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.createdDate = createdDate;
    }

    public Vote(long userId, long restaurantId, LocalDate createdDate) {
        this(null, userId, restaurantId, createdDate);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }


    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", userId=" + userId +
                ", restaurantId=" + restaurantId +
                ", createdDate=" + createdDate +
                '}';
    }
}
