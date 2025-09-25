package com.example.booking.mediator;

public interface ISender {
    <TResponse> TResponse send(ICommand<TResponse> command);
}