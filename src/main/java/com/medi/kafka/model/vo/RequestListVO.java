package com.medi.kafka.model.vo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Builder
public class RequestListVO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Valid
    @NotEmpty(message = "{validation.common.field.required}")
    private List<T> data;
}
