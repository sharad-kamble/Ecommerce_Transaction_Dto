#Ecommerce_Transaction_Dto

# 🧾 Spring Boot Transaction Management using DTO 

This project demonstrates how to manage **Transactions** in Spring Boot using **DTOs (Data Transfer Objects)** and **Repositories**. It includes practical examples of applying different **Propagation** and **Isolation** levels using the `@Transactional` annotation.

---

## 📌 What is a Transaction?

In Spring Boot, a **Transaction** provides better control over database operations. Transactions ensure that a group of operations either complete successfully as a whole or rollback in case of failure, ensuring data consistency.

Spring enables transaction management using the `@Transactional` annotation. Behind the scenes, Spring uses **AOP (Aspect-Oriented Programming)** to create proxies that handle transaction logic such as `begin`, `commit`, and `rollback`.

---

## 🔄 Propagation Levels

Propagation refers to how transaction boundaries are handled when a method with a transaction calls another method with a transaction. Spring provides five main propagation levels:

| Propagation Level | Description |
|--------------------|-------------|
| **REQUIRED**       | Uses the current transaction if one exists; otherwise creates a new one. *(default)* |
| **REQUIRES_NEW**   | Suspends the existing transaction (if any) and starts a new one. |
| **NEVER**          | Throws an exception if a transaction exists. |
| **SUPPORTS**       | Joins the existing transaction if present; otherwise runs without one. |
| **MANDATORY**      | Must run within an existing transaction; throws an exception if none exists. |

---

## 🔐 Isolation Levels

Isolation levels define how transaction integrity is visibly maintained when multiple transactions are executing concurrently. Spring supports the following standard isolation levels:

| Isolation Level      | Description |
|-----------------------|-------------|
| **READ_UNCOMMITTED**  | Allows dirty reads. A transaction may read uncommitted data from another. |
| **READ_COMMITTED**    | Only reads committed data. Prevents dirty reads. *(default for many databases)* |
| **REPEATABLE_READ**   | Prevents non-repeatable reads. Ensures the same data is read repeatedly within the same transaction. |
| **SERIALIZABLE**      | Strictest level. Transactions are executed one at a time, preventing all concurrency issues but reducing performance. |

---

## 🛠️ How It Works

- DTOs are used to collect multiple data points in a single object for transactional processing.
- Service layer methods are annotated with `@Transactional`.
- Repository interfaces extend `JpaRepository` to handle database interactions.
- The service layer decides the transaction propagation and isolation behavior.

---

## 🧪 Example Use Case

```java
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public void processOrder(OrderPaymentDto dto) {
    saveOrder(dto);
    savePayment(dto);
    saveFeedback(dto);
}
