package io.xstefank;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
public class MyDelegate {

    @Inject
    RequestBean requestBean;

    AtomicInteger counter = new AtomicInteger();

    public String call() {
        return "Uni request bean " + requestBean + ", " + counter.incrementAndGet();
    }
}
