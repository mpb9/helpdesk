package com.bb.helpdesk_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.io.Serial;
import java.io.Serializable;

/*
create or replace TABLE HELPDESK.PUBLIC.TICKET (
	ID VARCHAR(32) NOT NULL,
	NAME VARCHAR(32) NOT NULL,
	EMAIL VARCHAR(64) NOT NULL,
	DSC VARCHAR(256) NOT NULL,
	STATUS VARCHAR(32) NOT NULL,
	primary key (ID)
);
*/
@Entity
@Table(name = "TICKET", schema = "PUBLIC")
public class Ticket implements Serializable {
    @Serial
    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @NotBlank
    @Column(name = "ID", nullable = false, length = 32)
    private String id;

    @NotBlank
    @Column(name = "NAME", nullable = false, length = 32)
    private String name;

    @NotBlank
    @Column(name = "EMAIL", nullable = false, length = 64)
    private String email;

    @NotBlank
    @Column(name = "DSC", nullable = false, length = 256)
    private String dsc;

    @NotBlank
    @Column(name = "STATUS", nullable = false, length = 32)
    private String status;

    public @NotBlank String getId() {
        return id;
    }

    public void setId(@NotBlank String id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @NotBlank String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank String email) {
        this.email = email;
    }

    public @NotBlank String getDsc() {
        return dsc;
    }

    public void setDsc(@NotBlank String dsc) {
        this.dsc = dsc;
    }

    public @NotBlank String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass())
            return false;

        Ticket that = (Ticket) o;

        return that.getId().equals(this.id);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dsc='" + dsc + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
