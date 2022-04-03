package me.neeejm.trackiniapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.neeejm.trackiniapi.models.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
    public List<Position> findTop10ByOrderByIdDesc();

}
