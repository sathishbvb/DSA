package com.sathish.ds.oops;

import java.util.List;

public interface Parent<T> {
    default void run(T data){
        this.mustImplement(data);
        towMustImplement(data);
    }
    void mustImplement(T data);

    void towMustImplement(T data);
}
