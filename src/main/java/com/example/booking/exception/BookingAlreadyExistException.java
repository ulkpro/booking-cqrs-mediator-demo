// exception/BookingAlreadyExistException.java
package com.example.booking.exception;

public class BookingAlreadyExistException extends RuntimeException {
    public BookingAlreadyExistException() {
        super("Booking already exists!");
    }
}
