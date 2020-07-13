package by.ipps.dao.service.impl;

import by.ipps.dao.entity.Position;
import by.ipps.dao.repository.PositionRepository;
import by.ipps.dao.service.PositionService;
import by.ipps.dao.service.base.BaseEntityServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl extends BaseEntityServiceImpl<Position, PositionRepository>
    implements PositionService {
  public PositionServiceImpl(PositionRepository repository) {
    super(repository);
  }
}
