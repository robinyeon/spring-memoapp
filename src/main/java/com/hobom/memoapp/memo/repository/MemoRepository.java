package com.hobom.memoapp.memo.repository;

import com.hobom.memoapp.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository <Memo, Long> {
}

