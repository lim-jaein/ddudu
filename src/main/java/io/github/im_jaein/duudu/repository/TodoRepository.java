package io.github.im_jaein.duudu.repository;

import io.github.im_jaein.duudu.domain.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
