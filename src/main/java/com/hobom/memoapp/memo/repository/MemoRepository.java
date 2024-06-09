package com.hobom.memoapp.memo.repository;

import com.hobom.memoapp.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findByDeletedIsFalse();

    Optional<Memo> findByTitle(String title);
}

