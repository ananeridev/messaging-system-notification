package com.anabneri.messagingsystem.notfication.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "registration")
public class Registration {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name="status_id")
    private Status status;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    public String getId() {
        return id;
    }

    public void setId(String activeid) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return createdAt;
    }

    public void setUpdatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registration that = (Registration) o;
        return Objects.equals(id, that.id)
                && Objects.equals(status, that.status)
                && Objects.equals(createdAt, that.createdAt)
                && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, createdAt, updatedAt);
    }


    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private Status status;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        private Builder() {
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder statusId(Status statusId) {
            this.status = statusId;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Registration build() {
            Registration registration = new Registration();
            registration.setId(id);
            registration.setStatus(status);
            registration.setCreatedAt(createdAt);
            registration.setUpdatedAt(updatedAt);
            return registration;
        }
    }
    }
