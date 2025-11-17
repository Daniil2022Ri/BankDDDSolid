package service;


public interface AuditService {

    void logCreate(String entityType, Object newEntity, String username);
    void logUpdate(String entityType, Object oldEntity, Object newEntity, String username);

}
