package io.shs0160.springapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveRequest {

    private String title;
    private String content;
    private String author;

}
