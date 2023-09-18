package com.usarb.exam;

import jakarta.persistence.*;
import org.springframework.data.domain.Persistable;

@MappedSuperclass
public class BaseEntity<ID> implements Persistable<ID> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;

    @Transient
    private boolean isNew;

    @Override
    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }
}
