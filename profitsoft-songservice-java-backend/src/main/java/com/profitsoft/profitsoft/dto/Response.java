package com.profitsoft.profitsoft.dto;

import lombok.*;

/**
 * Simple response entity with message
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Response {
    private String result;
}
