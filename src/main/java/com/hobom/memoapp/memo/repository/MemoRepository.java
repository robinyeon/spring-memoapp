package com.hobom.memoapp.memo.repository;

import com.hobom.memoapp.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findByDeletedIsFalse();
}

