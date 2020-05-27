package com.ssm.Pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Data
public class ResponseData implements Serializable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<?> data;

//    private Object data1;

//    private boolean success;
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    private Long total;

    public ResponseData(String code, List<?> data) {
        this.code = code;
        this.data = data;
    }

    public ResponseData(String code, String message, List<?> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
