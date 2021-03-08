package com.anabneri.messagingsystem.notfication.model;

import java.util.Objects;

public class Status {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Status)) return false;
        Status status = (Status) o;
        return id.equals(status.id) &&
                name.equals(status.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Integer id;
        private String name;

        private Builder() {
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Status build() {
            Status status = new Status();
            status.setId(id);
            status.setName(name);
            return status;
        }
    }
}
