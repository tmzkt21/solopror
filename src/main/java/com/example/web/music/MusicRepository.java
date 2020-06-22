package com.example.web.music;

import com.example.web.Entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<Music,Long> {
}
