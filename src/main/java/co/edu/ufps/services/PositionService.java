package co.edu.ufps.services;

import co.edu.ufps.entities.Position;
import co.edu.ufps.repositories.PositionRepository;
import java.util.Optional;

@Service
public class PositionService {
    @Autowired
    private PositionRepository positionRepository;

    public Optional<Position> findPositionById(Long id) {
        return positionRepository.findById(id);
    }
}

