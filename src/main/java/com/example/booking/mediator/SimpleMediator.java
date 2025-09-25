package com.example.booking.mediator;

import org.springframework.context.ApplicationContext;

public class SimpleMediator implements IMediator {
    private final ApplicationContext context;

    public SimpleMediator(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public <TResponse> TResponse send(ICommand<TResponse> command) {
        @SuppressWarnings("unchecked")
        ICommandHandler<ICommand<TResponse>, TResponse> handler =
                (ICommandHandler<ICommand<TResponse>, TResponse>) context.getBean(command.getClass().getSimpleName() + "Handler");
        return handler.handle(command);
    }
}
