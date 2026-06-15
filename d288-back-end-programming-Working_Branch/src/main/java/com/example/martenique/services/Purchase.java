package com.example.martenique.services;

import com.example.martenique.entities.Cart;
import com.example.martenique.entities.CartItem;
import com.example.martenique.entities.Customer;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
public class Purchase {

    private Cart cart;
    private Set<CartItem> cartItems;
    private Customer customer;
}
