package com.medi.kafka.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageDTO implements Serializable {

    private static final long serialVersionUID = 6547517470293557885L;

    private String message;

}
