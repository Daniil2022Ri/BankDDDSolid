package controller;

import dto.SuspiciousAccountTransferDto;
import dto.SuspiciousCardTransferDto;
import dto.SuspiciousPhoneTransferDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.SuspiciousTransferService;
import service.SuspiciousTransferServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/suspicious-transfers")
@AllArgsConstructor
public class SuspiciousTransferController {

    private final SuspiciousTransferService service;

    @PostMapping("/card")
    public ResponseEntity<SuspiciousCardTransferDto> createCard(@RequestBody SuspiciousCardTransferDto dto) {
        return ResponseEntity.ok(service.createCard(dto));
    }

    @PostMapping("/phone")
    public ResponseEntity<SuspiciousPhoneTransferDto> createPhone(@RequestBody SuspiciousPhoneTransferDto dto) {
        return ResponseEntity.ok(service.createPhone(dto));
    }

    @PostMapping("/account")
    public ResponseEntity<SuspiciousAccountTransferDto> createAccount(@RequestBody SuspiciousAccountTransferDto dto) {
        return ResponseEntity.ok(service.createAccount(dto));
    }

    @PutMapping("/{type}/{id}")
    public ResponseEntity<?> update(@PathVariable String type, @PathVariable Long id, @RequestBody Object dto) {
        return switch (type.toLowerCase()) {
            case "card" -> ResponseEntity.ok(service.updateCard(id, (SuspiciousCardTransferDto) dto));
            case "phone" -> ResponseEntity.ok(service.updatePhone(id, (SuspiciousPhoneTransferDto) dto));
            case "account" -> ResponseEntity.ok(service.updateAccount(id, (SuspiciousAccountTransferDto) dto));
            default -> ResponseEntity.badRequest().body("Invalid type");
        };
    }

    @DeleteMapping("/{type}/{id}")
    public ResponseEntity<Void> delete(@PathVariable String type, @PathVariable Long id) {
        service.delete(id, type);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<?>> getAll(@RequestParam String type) {
        return ResponseEntity.ok(service.getAll(type));
    }

    @GetMapping("/{type}/{id}")
    public ResponseEntity<?> getById(@PathVariable String type, @PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id, type));
    }
}
