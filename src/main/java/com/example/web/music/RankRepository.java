package com.example.web.music;

import com.example.web.Entity.Help;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankRepository extends JpaRepository<Help,Long> {
}

