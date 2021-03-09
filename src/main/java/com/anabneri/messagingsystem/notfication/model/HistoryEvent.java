package com.anabneri.messagingsystem.notfication.model;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Objects;

public class HistoryEvent {

    private Integer id;
    private Type type;
    private Registration registrationId;
    private LocalDateTime createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Registration getSubscriptionId() {
        return registrationId;
    }

    public void setSubscriptionId(Registration subscriptionId) {
        this.registrationId = registrationId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryEvent that = (HistoryEvent) o;
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
        private Type type;
        private Registration registrationId;
        private LocalDateTime createdAt;

        private Builder() {
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder type(Type type) {
            this.type = type;
            return this;
        }

        public Builder subscriptionId(Registration registrationId) {
            this.registrationId = registrationId;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public HistoryEvent build() {
            HistoryEvent eventHistory = new HistoryEvent();
            eventHistory.setId(id);
            eventHistory.setType(type);
            eventHistory.setSubscriptionId(registrationId);
            eventHistory.setCreatedAt(createdAt);
            return eventHistory;
        }
    }
}
