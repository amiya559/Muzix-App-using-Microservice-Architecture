package com.example.favlistservice.repositories;

import com.example.favlistservice.entities.Tracks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MusicRepositories extends JpaRepository<Tracks, Integer> { }
