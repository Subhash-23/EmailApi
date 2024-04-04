package com.email.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequest {

    private String to;
    private String subject;
    private String text;

    // Optional fields for attachments and inline images
    private String attachmentPath;
    private String contentId;

    // Getters and setters for all fields

}
