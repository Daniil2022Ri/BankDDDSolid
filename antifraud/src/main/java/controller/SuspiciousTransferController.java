package controller;

import dto.SuspiciousAccountTransferDto;
import dto.SuspiciousCardTransferDto;
import dto.SuspiciousPhoneTransferDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.SuspiciousTransferService;



import java.util.List;

@RestController
@RequestMapping("/suspicious-transfers")
@AllArgsConstructor
public class SuspiciousTransferController {

    private final SuspiciousTransferService service;

    @Operation(
            summary = "Создать подозрительную транзакцию карты",
            description = "Создает новую запись о подозрительной транзакции по карте"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Транзакция успешно создана",
                    content = @Content(schema = @Schema(implementation = SuspiciousCardTransferDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Невалидные данные",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Внутренняя ошибка сервера",
                    content = @Content
            )
    })
    @PostMapping("/card")
    public ResponseEntity<SuspiciousCardTransferDto> createCard(
            @Parameter(description = "DTO для создания подозрительной транзакции карты", required = true)
            @RequestBody @Valid SuspiciousCardTransferDto dto) {
        SuspiciousCardTransferDto result = service.createCard(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Operation(
            summary = "Создать подозрительную транзакцию телефона",
            description = "Создает новую запись о подозрительной транзакции по телефону"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Транзакция успешно создана"),
            @ApiResponse(responseCode = "400", description = "Невалидные данные"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    @PostMapping("/phone")
    public ResponseEntity<SuspiciousPhoneTransferDto> createPhone(
            @Parameter(description = "DTO для создания подозрительной транзакции телефона", required = true)
            @RequestBody @Valid SuspiciousPhoneTransferDto dto) {
        SuspiciousPhoneTransferDto result = service.createPhone(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Operation(
            summary = "Создать подозрительную транзакцию аккаунта",
            description = "Создает новую запись о подозрительной транзакции по аккаунту"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Транзакция успешно создана"),
            @ApiResponse(responseCode = "400", description = "Невалидные данные"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    @PostMapping("/account")
    public ResponseEntity<SuspiciousAccountTransferDto> createAccount(
            @Parameter(description = "DTO для создания подозрительной транзакции аккаунта", required = true)
            @RequestBody @Valid SuspiciousAccountTransferDto dto) {
        SuspiciousAccountTransferDto result = service.createAccount(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Operation(
            summary = "Обновить подозрительную транзакцию карты",
            description = "Обновляет данные подозрительной транзакции карты по ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Транзакция успешно обновлена"),
            @ApiResponse(responseCode = "404", description = "Транзакция не найдена"),
            @ApiResponse(responseCode = "400", description = "Невалидные данные")
    })
    @PutMapping("/card/{id}")
    public ResponseEntity<SuspiciousCardTransferDto> updateCard(
            @Parameter(description = "ID транзакции", required = true, example = "1")
            @PathVariable Long id,
            @Parameter(description = "DTO для обновления подозрительной транзакции карты", required = true)
            @RequestBody @Valid SuspiciousCardTransferDto dto) {
        SuspiciousCardTransferDto result = service.updateCard(id, dto);
        return ResponseEntity.ok(result);
    }

    @Operation(
            summary = "Обновить подозрительную транзакцию телефона",
            description = "Обновляет данные подозрительной транзакции телефона по ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Транзакция успешно обновлена"),
            @ApiResponse(responseCode = "404", description = "Транзакция не найдена")
    })
    @PutMapping("/phone/{id}")
    public ResponseEntity<SuspiciousPhoneTransferDto> updatePhone(
            @Parameter(description = "ID транзакции", required = true, example = "1")
            @PathVariable Long id,
            @Parameter(description = "DTO для обновления подозрительной транзакции телефона", required = true)
            @RequestBody @Valid SuspiciousPhoneTransferDto dto) {
        SuspiciousPhoneTransferDto result = service.updatePhone(id, dto);
        return ResponseEntity.ok(result);
    }

    @Operation(
            summary = "Обновить подозрительную транзакцию аккаунта",
            description = "Обновляет данные подозрительной транзакции аккаунта по ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Транзакция успешно обновлена"),
            @ApiResponse(responseCode = "404", description = "Транзакция не найдена")
    })
    @PutMapping("/account/{id}")
    public ResponseEntity<SuspiciousAccountTransferDto> updateAccount(
            @Parameter(description = "ID транзакции", required = true, example = "1")
            @PathVariable Long id,
            @Parameter(description = "DTO для обновления подозрительной транзакции аккаунта", required = true)
            @RequestBody @Valid SuspiciousAccountTransferDto dto) {
        SuspiciousAccountTransferDto result = service.updateAccount(id, dto);
        return ResponseEntity.ok(result);
    }
    /*
    @PutMapping("/{type}/{id}")
    public ResponseEntity<?> update(@PathVariable String type, @PathVariable Long id, @RequestBody Object dto) {
        return switch (type.toLowerCase()) {
            case "card" -> ResponseEntity.ok(service.updateCard(id, (SuspiciousCardTransferDto) dto));
            case "phone" -> ResponseEntity.ok(service.updatePhone(id, (SuspiciousPhoneTransferDto) dto));
            case "account" -> ResponseEntity.ok(service.updateAccount(id, (SuspiciousAccountTransferDto) dto));
            default -> ResponseEntity.badRequest().body("Invalid type");
        };
    }
    */
    @DeleteMapping("/card/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        service.deleteSuspiciousTransfer(id, "card");
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/phone/{id}")
    public ResponseEntity<Void> deletePhone(@PathVariable Long id) {
        service.deleteSuspiciousTransfer(id, "phone");
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/account/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        service.deleteSuspiciousTransfer(id, "account");
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/card")
    public ResponseEntity<List<SuspiciousCardTransferDto>> getAllCards() {
        return ResponseEntity.ok(service.getAllCards());
    }

    @GetMapping("/phone")
    public ResponseEntity<List<SuspiciousPhoneTransferDto>> getAllPhones() {
        return ResponseEntity.ok(service.getAllPhones());
    }

    @GetMapping("/account")
    public ResponseEntity<List<SuspiciousAccountTransferDto>> getAllAccounts() {
        return ResponseEntity.ok(service.getAllAccounts());
    }

    @GetMapping("/card/{id}")
    public ResponseEntity<SuspiciousCardTransferDto> getCardById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCardById(id));
    }

    @GetMapping("/phone/{id}")
    public ResponseEntity<SuspiciousPhoneTransferDto> getPhoneById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPhoneById(id));
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<SuspiciousAccountTransferDto> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAccountById(id));
    }
}
