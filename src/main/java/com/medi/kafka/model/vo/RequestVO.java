package com.medi.kafka.model.vo;

import jakarta.validation.Valid;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Builder
public class RequestVO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Valid
    private T data;
}
