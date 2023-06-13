package com.Hbaraki.calender.model;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;


public record Content(
        @Id

        Integer id,
        @NotBlank
        String title,
        String desc,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {}

