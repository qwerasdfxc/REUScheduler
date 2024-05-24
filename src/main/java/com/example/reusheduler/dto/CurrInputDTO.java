package com.example.reusheduler.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.web.bind.annotation.RequestParam;

@Builder
@ToString
@Data
public class CurrInputDTO {

    Long groupId;
     Long module;
}
