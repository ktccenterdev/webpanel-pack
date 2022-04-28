package net.ktc.pack.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class AbstractDefaultValues {

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date created;

    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date updated;

    private Boolean isDefault = false;

    private Boolean isVisible = true;

    @PrePersist
    protected void onCreate(){
        created = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        updated = new Date();
    }
}
