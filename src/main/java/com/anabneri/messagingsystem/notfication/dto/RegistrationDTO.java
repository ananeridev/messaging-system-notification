package com.anabneri.messagingsystem.notfication.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrationDTO {

        private String id;

        @JsonProperty("status_id")
        private StatusDTO status;

        @JsonProperty("created_at")
        private OffsetDateTime createdAt;

        @JsonProperty("updated_at")
        private OffsetDateTime updatedAt;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public StatusDTO getStatus() {
            return status;
        }

        public void setStatus(StatusDTO status) {
            this.status = status;
        }

        public OffsetDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
        }

        public OffsetDateTime getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = updatedAt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RegistrationDTO that = (RegistrationDTO) o;
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
            private StatusDTO status;
            private OffsetDateTime createdAt;
            private OffsetDateTime updatedAt;

            private Builder() {
            }

            public Builder id(String id) {
                this.id = id;
                return this;
            }

            public Builder statusId(StatusDTO statusId) {
                this.status = statusId;
                return this;
            }

            public Builder createdAt(OffsetDateTime createdAt) {
                this.createdAt = createdAt;
                return this;
            }

            public Builder updatedAt(OffsetDateTime updatedAt) {
                this.updatedAt = updatedAt;
                return this;
            }

            public RegistrationDTO build() {
                RegistrationDTO registration = new RegistrationDTO();
                registration.setId(id);
                registration.setStatus(status);
                registration.setCreatedAt(createdAt);
                registration.setUpdatedAt(updatedAt);
                return registration;
            }
        }

    }
