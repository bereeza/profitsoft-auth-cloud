package com.profitsoft.profitsoft.repository;

import com.profitsoft.profitsoft.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.NonNull;

public interface SongRepository extends JpaRepository<Song, Long>, JpaSpecificationExecutor<Song> {
    @NonNull
    Page<Song> findAll(@NonNull Specification<Song> specification, @NonNull Pageable pageable);
}

