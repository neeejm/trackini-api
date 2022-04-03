package me.neeejm.trackiniapi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.neeejm.trackiniapi.models.Position;
import me.neeejm.trackiniapi.repository.PositionRepository;

@RestController
@RequestMapping("/positions")
public class PositionController {
    @Autowired
    private PositionRepository positionRepository;

    @GetMapping
    public List<Position> get(@RequestParam(required = false) String size) {
        if (size == null)
            return positionRepository.findAll();

        return positionRepository.findTop10ByOrderByIdDesc();
    }

    @PostMapping
    public Map<String, String> post(@RequestBody Position position) {
        Map<String, String> m = new HashMap<>();
        for (Position p : positionRepository.findAll()) {
            if (p.getLatitude() == position.getLatitude() && p.getLongitude() == position.getLongitude()) {
                m.put("msg", "already in");
                return m;
            }
        }
        positionRepository.save(position);
        m.put("msg", "ok");
        return m;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        positionRepository.deleteById(id);
    }
}
