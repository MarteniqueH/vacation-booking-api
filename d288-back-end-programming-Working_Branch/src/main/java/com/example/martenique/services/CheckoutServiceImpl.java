package com.example.martenique.services;

import com.example.martenique.dao.CartRepository;
import com.example.martenique.dao.CartItemRepository;
import com.example.martenique.dao.CustomerRepository;
import com.example.martenique.dao.VacationRepository;
import com.example.martenique.dao.ExcursionRepository;
import com.example.martenique.entities.Cart;
import com.example.martenique.entities.CartItem;
import com.example.martenique.entities.Excursion;
import com.example.martenique.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final CustomerRepository customerRepository;
    private final VacationRepository vacationRepository;
    private final ExcursionRepository excursionRepository;

    public CheckoutServiceImpl(CartRepository cartRepository,
                               CartItemRepository cartItemRepository,
                               CustomerRepository customerRepository,
                               VacationRepository vacationRepository,
                               ExcursionRepository excursionRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.customerRepository = customerRepository;
        this.vacationRepository = vacationRepository;
        this.excursionRepository = excursionRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        Cart cart = purchase.getCart();
        cart.setOrderTrackingNumber(UUID.randomUUID().toString());
        cart.setStatus(StatusType.ordered);

        if (purchase.getCartItems() != null) {
            for (CartItem item : purchase.getCartItems()) {
                cart.add(item);
               item.setCart(cart);

                if (item.getExcursions() != null) {
                    for (Excursion excursion : item.getExcursions()) {
                        if (excursion.getCartItems() != null) {
                            excursion.getCartItems().add(item);
                        }
                    }
                }

                if (item.getVacation() != null) {
                    vacationRepository.save(item.getVacation());
                }
            }
        }

        if (purchase.getCustomer() != null) {
            customerRepository.save(purchase.getCustomer());
        }

        cartRepository.save(cart);

        return new PurchaseResponse(cart.getOrderTrackingNumber());
    }
}