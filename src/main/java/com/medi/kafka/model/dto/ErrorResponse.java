package com.medi.kafka.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse implements Serializable {

    private static final long serialVersionUID = 7084482713497826747L;

    private List<ErrorCode> errors;

    public ErrorResponse(ErrorCode error) {
        this.errors = List.of(error);
    }
}
