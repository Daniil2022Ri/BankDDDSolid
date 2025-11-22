package Controller;

import dto.AccountDto;
import dto.AuditDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.AccountService;
import service.AuditService;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    //============================= Controller Account ==========================
    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto ,
                                                    @RequestHeader("user_id") String userId){
        AccountDto createAccount = accountService.createAccount(accountDto , userId);
        return new ResponseEntity<>(createAccount , HttpStatus.CREATED);
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
    @PutMapping("accounts/{id}")
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

    @DeleteMapping("accounts/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id,
                                              @RequestHeader("user_id") String userId) {
        boolean deleted = accountService.deleteAccount(id, userId);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/accounts/{entityType}")
    public ResponseEntity<List<AccountDto>> getAccountsByEntityType(@PathVariable String entityType) {
        List<AccountDto> accounts = accountService.findByEntityType(entityType);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/accounts/{createdBy}")
    public ResponseEntity<List<AccountDto>> getAccountsByCreator(@PathVariable String createdBy) {
        List<AccountDto> accounts = accountService.findByCreatedBy(createdBy);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/accounts/{operationType}")
    public ResponseEntity<List<AccountDto>> getAccountsByOperationType(@PathVariable String operationType) {
        List<AccountDto> accounts = accountService.findByOperationType(operationType);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    //============================= Controller Audit ==========================

    private final AuditService auditService;

    @PostMapping
    public ResponseEntity<AuditDto> createAudit(@RequestBody AuditDto auditDto) {
        AuditDto createdAudit = auditService.createAudit(auditDto);
        return new ResponseEntity<>(createdAudit, HttpStatus.CREATED);
    }

    @GetMapping("accounts/{id}")
    public ResponseEntity<AuditDto> getAuditById(@PathVariable Long id) {
        return auditService.findAuditById(id)
                .map(audit -> new ResponseEntity<>(audit, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<AuditDto>> getAllAudits() {
        List<AuditDto> audits = auditService.findAllAudits();
        return new ResponseEntity<>(audits, HttpStatus.OK);
    }

    @GetMapping("/password/{passwordId}")
    public ResponseEntity<List<AuditDto>> getAuditsByPasswordId(@PathVariable Long passwordId) {
        List<AuditDto> audits = auditService.findByPasswordId(passwordId);
        return new ResponseEntity<>(audits, HttpStatus.OK);
    }

    @GetMapping("/account-number/{accountNumber}")
    public ResponseEntity<List<AuditDto>> getAuditsByAccountNumber(@PathVariable Long accountNumber) {
        List<AuditDto> audits = auditService.findByAccountNumber(accountNumber);
        return new ResponseEntity<>(audits, HttpStatus.OK);
    }

    @GetMapping("/profile/{profileId}")
    public ResponseEntity<List<AuditDto>> getAuditsByProfileId(@PathVariable Long profileId) {
        List<AuditDto> audits = auditService.findByProfileId(profileId);
        return new ResponseEntity<>(audits, HttpStatus.OK);
    }

    @GetMapping("/negative-balance/{negativeBalance}")
    public ResponseEntity<List<AuditDto>> getAuditsByNegativeBalance(@PathVariable boolean negativeBalance) {
        List<AuditDto> audits = auditService.findByNegativeBalance(negativeBalance);
        return new ResponseEntity<>(audits, HttpStatus.OK);
    }
}
