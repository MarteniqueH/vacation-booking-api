package com.example.martenique.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_first_name")
    @NotNull(message = "First Name Required")
    private String firstName;

    @Column(name = "customer_last_name")
    @NotNull(message = "Last Name Required")
    private String lastName;

    @Column(name = "address")
    @NotBlank(message = "Address Required")
    private String address;

    @NotBlank(message = "Phone number required")
    @Column(name = "phone")
    private String phone;

    @Column(name = "postal_code")
    @NotBlank(message = "Postal Code required")
    @Size(min = 5, max = 15, message = "Postal Code is required to be between 5 and 15 characters long.")
    private String postal_code;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;


    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Cart> carts;
}
