package com.profitsoft.profitsoft.exception.song;

/**
 * Song not found -> 404 Not Found
 */
public class SongNotFoundException extends RuntimeException {
    public SongNotFoundException() {
    }

    public SongNotFoundException(String message) {
        super(message);
    }
}
