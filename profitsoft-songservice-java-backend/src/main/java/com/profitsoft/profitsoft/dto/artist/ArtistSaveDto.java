package com.profitsoft.profitsoft.dto.artist;

import com.profitsoft.profitsoft.entity.Song;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Artist entity to save
 */
@Getter
@Setter
@Builder
public class ArtistSaveDto {
    private long artistId;
    @NotBlank(message = "Artist Name is mandatory!")
    @Size(min = 3, max = 256)
    private String artistName;
    @NotBlank(message = "Artist Country is mandatory!")
    @Size(min = 3, max = 256)
    private String artistCountry;
    private List<Song> songs;
}