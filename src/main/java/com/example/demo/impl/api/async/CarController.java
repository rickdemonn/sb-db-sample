package com.example.demo.impl.api.async;

import com.example.demo.app.dto.CarRequest;
import com.example.demo.app.dto.CarResponse;
import com.example.demo.app.model.Car;
import com.example.demo.app.service.CarService;
import com.example.demo.common_impl.api.AsyncAbstractBaseController;
import com.example.demo.commons.dto.OnCreate;
import com.example.demo.commons.dto.OnUpdate;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping("cars")
public class CarController extends AsyncAbstractBaseController<Car, Integer, CarRequest, CarResponse> {

    protected CarController(CarService service, Executor taskExecutor) {
        super(service, taskExecutor);
    }

    @Override
    @PostMapping
    public CompletableFuture<CarResponse> create(@RequestBody @Validated(OnCreate.class) CarRequest request) {
        return super.create(request);
    }

    @Override
    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<CarResponse>> getById(@PathVariable Integer id) {
        return super.getById(id);
    }

    @Override
    @GetMapping
    public CompletableFuture<List<CarResponse>> getAll() {
        return super.getAll();
    }

    @Override
    @PatchMapping("/{id}")
    public CompletableFuture<ResponseEntity<CarResponse>> update(@PathVariable Integer id, @RequestBody @Validated(OnUpdate.class) CarRequest request) {
        return super.update(id, request);
    }

    @Override
    @DeleteMapping("/{id}")
    public CompletableFuture<Void> delete(@PathVariable Integer id) {
         return super.delete(id);
    }
}
