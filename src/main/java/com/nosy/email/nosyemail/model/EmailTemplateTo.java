package com.nosy.email.nosyemail.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component

public class EmailTemplateTo {
    private int status;
    private String address;

}
