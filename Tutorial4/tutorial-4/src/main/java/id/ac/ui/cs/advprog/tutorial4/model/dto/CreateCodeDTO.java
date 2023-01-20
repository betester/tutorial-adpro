package id.ac.ui.cs.advprog.tutorial4.model.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CreateCodeDTO {
    String codeType;
    String itemType;
    String code;
    String item;
    Map<String, String> data;
}
