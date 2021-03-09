package com.anabneri.messagingsystem.notfication.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HistoryEventDTO {

    private Integer id;
    private String type;
    private RegistrationDTO registrationId;
    private OffsetDateTime createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RegistrationDTO getRegistrationDTO() {
        return registrationId;
    }

    public void setRegistrationId(RegistrationDTO registrationId) {
        this.registrationId = registrationId;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryEventDTO that = (HistoryEventDTO) o;
        return Objects.equals(id, that.id)
                && Objects.equals(type, that.type)
                && Objects.equals(registrationId, that.registrationId)
                && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, registrationId, createdAt);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Integer id;
        private String type;
        private RegistrationDTO registrationId;
        private OffsetDateTime createdAt;

        private Builder() {
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder subscriptionId(RegistrationDTO registrationId) {
            this.registrationId = registrationId;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public HistoryEventDTO build() {
            HistoryEventDTO eventHistory = new HistoryEventDTO();
            eventHistory.setId(id);
            eventHistory.setType(type);
            eventHistory.setRegistrationId(registrationId);
            eventHistory.setCreatedAt(createdAt);
            return eventHistory;
        }
    }
}
