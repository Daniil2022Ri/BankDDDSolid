package Controller;

import dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.AccountService;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto,
                                                    @RequestHeader("user_id") String userId) {
        AccountDto createdAccount = accountService.createAccount(accountDto, userId);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        return accountService.findById(id)
                .map(account -> new ResponseEntity<>(account, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accounts = accountService.findAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PutMapping("/accounts/{id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable Long id,
                                                    @RequestBody AccountDto accountDto,
                                                    @RequestHeader("user_id") String userId) {
        try {
            AccountDto updatedAccount = accountService.updateAccount(id, accountDto, userId);
            return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id,
                                              @RequestHeader("user_id") String userId) {
        boolean deleted = accountService.deleteAccount(id, userId);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/entity-type/{entityType}")
    public ResponseEntity<List<AccountDto>> getAccountsByEntityType(@PathVariable String entityType) {
        List<AccountDto> accounts = accountService.findByEntityType(entityType);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/created-by/{createdBy}")
    public ResponseEntity<List<AccountDto>> getAccountsByCreator(@PathVariable String createdBy) {
        List<AccountDto> accounts = accountService.findByCreatedBy(createdBy);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/operation-type/{operationType}")
    public ResponseEntity<List<AccountDto>> getAccountsByOperationType(@PathVariable String operationType) {
        List<AccountDto> accounts = accountService.findByOperationType(operationType);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
}
