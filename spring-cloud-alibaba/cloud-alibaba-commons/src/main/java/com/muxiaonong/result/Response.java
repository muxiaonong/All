package com.muxiaonong.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {

    private Integer code;

    private String msg;

    private T data;

}
