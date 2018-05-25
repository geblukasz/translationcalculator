package com.translationcalculator.translationform.exception.storageException;

import com.translationcalculator.translationform.exception.storageException.StorageException;

public class StorageFileNotFoundException extends StorageException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}