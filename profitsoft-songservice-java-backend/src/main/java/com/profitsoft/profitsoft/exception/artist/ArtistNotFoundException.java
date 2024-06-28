package com.profitsoft.profitsoft.exception.artist;

/**
 * Artist not found -> 404 Not Found
 */
public class ArtistNotFoundException extends RuntimeException {
    public ArtistNotFoundException() {
    }

    public ArtistNotFoundException(String message) {
        super(message);
    }
}
