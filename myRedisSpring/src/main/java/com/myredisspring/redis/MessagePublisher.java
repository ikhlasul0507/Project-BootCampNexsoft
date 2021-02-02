package com.myredisspring.redis;

public interface MessagePublisher {
    void publish(final String message);
}

