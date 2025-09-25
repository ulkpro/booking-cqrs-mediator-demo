// mediator/ICommandHandler.java
package com.example.booking.mediator;

public interface ICommandHandler<TCommand extends ICommand<TResponse>, TResponse> {
    TResponse handle(TCommand command);
}