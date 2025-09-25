# Booking CQRS + Mediator Demo

A minimal **Spring Boot** project showcasing key design patterns and architectural principles:

## Features
- **CQRS (Command Query Responsibility Segregation)**  
  - Commands (`CreateBookingCommand`) handle writes.  
  - Queries (`GetBookingByIdQuery`, `GetAllBookingsQuery`) handle reads.

- **Mediator Pattern**  
  - Controllers send requests through `IMediator`, decoupling them from business logic.  
