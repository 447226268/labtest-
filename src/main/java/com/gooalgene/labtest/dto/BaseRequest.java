package com.gooalgene.labtest.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseRequest<T> {
    private T requestment;

    public BaseRequest() {

    }

    public BaseRequest(T requestment) {
        this.requestment = requestment;
    }
}
