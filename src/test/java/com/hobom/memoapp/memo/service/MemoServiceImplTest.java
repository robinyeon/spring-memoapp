package com.hobom.memoapp.memo.service;

import com.hobom.memoapp.memo.dto.MemoDto;
import com.hobom.memoapp.memo.entity.Memo;
import com.hobom.memoapp.memo.repository.MemoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemoServiceImplTest {

    @Autowired
    private MemoServiceImpl memoService;

    @Autowired
    private MemoRepository memoRepository;

//    @Test
//    public void 메모는_무조건_생성_되어야한다() {
//        Memo memo = new Memo("타이틀", "콘텐츠");
//        MemoDto.Request memoCreatRequestDto = new MemoDto.Request(memo);
//
//        memoService.createOneMemo(memoCreatRequestDto);
//
//        Memo foundMemo = memoRepository.findByTitle(memo.getTitle()).orElseThrow(() -> new EntityNotFoundException("Memo not found."));
//
//        Assertions.assertThat(foundMemo.getTitle()).isEqualTo(memo.getTitle());
//    }
}
