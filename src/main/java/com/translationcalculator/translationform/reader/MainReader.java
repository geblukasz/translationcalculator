package com.translationcalculator.translationform.reader;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MainReader {


    private boolean isUseCatTools;
    private boolean isTaxPayer;
    private int signsNumberWithSpaces;
    private int pageVolume;
    private int pagesNumber;
    private double stake;
    private double price;

}
