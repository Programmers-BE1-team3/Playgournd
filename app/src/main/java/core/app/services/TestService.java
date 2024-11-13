package core.app.services;

import core.app.models.*;
import core.app.repositories.*;
import java.util.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class TestService {

    private final TestRepo repo;

    public boolean getFalse() {
        return false;
    }

    public TestEntity save(TestEntity entity) {
        return repo.save(entity);
    }

    public Optional<TestEntity> findById(long id) {
        return repo.findById(id);
    }

    public void deleteById(long id) {
        repo.deleteById(id);
    }

    public void helloWorld() {
        log.info("Hello World");
    }
}
