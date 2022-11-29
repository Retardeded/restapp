package com.recruit.restapp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NumbersSortData {
    List<Integer> numbers;
    String order;
    //maybe try enum instead of string
}
