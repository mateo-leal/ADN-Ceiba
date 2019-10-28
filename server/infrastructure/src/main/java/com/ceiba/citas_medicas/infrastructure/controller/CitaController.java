package com.ceiba.citas_medicas.infrastructure.controller;

import com.ceiba.citas_medicas.domain.model.Cita;
import com.ceiba.citas_medicas.infrastructure.persistence.CitaRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitaController {

    private final CitaRepository repository;

    public CitaController(CitaRepository repository) {
        this.repository = repository;
    }

    /**
     * Obtiene todas las citas, and transform them into a REST collection resource using
     * {@link EmployeeRepresentationModelAssembler#toCollectionModel(Iterable)}. Then return them through Spring Web's
     * {@link ResponseEntity} fluent API.
     */
    @GetMapping("/citas")
    public ResponseEntity<CollectionModel<EntityModel<Cita>>> findAll() {

        return ResponseEntity.ok(assembler.toCollectionModel(repository.findAll()));

    }

    @PostMapping("/orders/{id}/cancel")
    ResponseEntity<?> cancel(@PathVariable Long id) {

        Order order = this.repository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));

        if (valid(order.getOrderStatus(), OrderStatus.CANCELLED)) {

            order.setOrderStatus(OrderStatus.CANCELLED);
            return ResponseEntity.ok(repository.save(order));
        }

        return ResponseEntity.badRequest()
                .body("Transitioning from " + order.getOrderStatus() + " to " + OrderStatus.CANCELLED + " is not valid.");
    }

    @PostMapping("/orders/{id}/fulfill")
    ResponseEntity<?> fulfill(@PathVariable Long id) {

        Order order = this.repository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));

        if (valid(order.getOrderStatus(), OrderStatus.FULFILLED)) {

            order.setOrderStatus(OrderStatus.FULFILLED);
            return ResponseEntity.ok(repository.save(order));
        }

        return ResponseEntity.badRequest()
                .body("Transitioning from " + order.getOrderStatus() + " to " + OrderStatus.FULFILLED + " is not valid.");
    }
}
