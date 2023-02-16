package com.example.enigma_z2.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageHelper {
    private Integer number;
    private Integer size;
    private Sort.Direction sort;
    private String sortedFieldName;

    public static PageRequest getPage(PageHelper pageHelper) {
        return PageRequest.of(pageHelper.getNumber(), pageHelper.getSize(), pageHelper.getSort(), pageHelper.getSortedFieldName());
    }

    public PageRequest getPage(){
        return PageRequest.of(getNumber(), getSize(), getSort(), getSortedFieldName());
    }

    public String getSortedFieldName() {
        return (sortedFieldName != null) ? sortedFieldName : "id";
    }

    public int getNumber() {
        return (number != null) ? number : 0;
    }

    public int getSize() {
        return (size != null) ? size : 10;
    }

    public Sort.Direction getSort() {
        return (sort != null) ? sort : Sort.Direction.ASC;
    }
}
