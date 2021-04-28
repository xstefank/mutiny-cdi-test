package io.xstefank;

import javax.enterprise.context.RequestScoped;
import java.util.Random;

@RequestScoped
public class RequestBean {

    public int getRandom() {
        return new Random().nextInt();
    }
}
