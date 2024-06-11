package com.hobom.memoapp.memo.service;

import com.hobom.memoapp.memo.dto.MemoDto;
import com.hobom.memoapp.memo.entity.Memo;
import com.hobom.memoapp.memo.repository.MemoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MemoServiceImplTest {
    @Mock
    MemoRepository memoRepository;

    @InjectMocks
    MemoServiceImpl memoService;

    @Test
    @DisplayName("메모는 반드시 생성되어야 한다.")
    void 메모_생성하기() {
        MemoDto.Request createRequestDto = new MemoDto.Request("타이틀", "콘텐츠");
        Memo memo = new Memo("타이틀", "콘텐츠");

        given(memoRepository.save(any(Memo.class))).willReturn(memo);

        MemoDto.Response createdMemo = memoService.createOneMemo(createRequestDto);

        assertThat(createdMemo.getTitle()).isEqualTo("타이틀");
        assertThat(createdMemo.getContents()).isEqualTo("콘텐츠");
    }

    @Test
    @DisplayName("모든 메모를 가져와야 한다.")
    void 모든_메모_가져오기() {
        Memo memo1 = new Memo("타이틀1", "콘텐츠1");
        Memo memo2 = new Memo("타이틀2", "콘텐츠2");
        List<Memo> memos = Arrays.asList(memo1, memo2);

        given(memoRepository.findByDeletedIsFalse()).willReturn(memos);

        List<MemoDto.Response> foundMemos = memoService.getAllMemo();

        assertThat(foundMemos).hasSize(2);
        assertThat(foundMemos.get(0).getTitle()).isEqualTo("타이틀1");
        assertThat(foundMemos.get(0).getContents()).isEqualTo("콘텐츠1");
        assertThat(foundMemos.get(1).getTitle()).isEqualTo("타이틀2");
        assertThat(foundMemos.get(1).getContents()).isEqualTo("콘텐츠2");
    }

    @Test
    @DisplayName("해당 ID값을 가진 메모를 가져와야 한다.")
    void 하나의_메모_ID로_가져오기() {
        Memo memo = new Memo("타이틀", "콘텐츠");

        given(memoRepository.findById(any(Long.class))).willReturn(Optional.of(memo));

        MemoDto.Response foundMemo = memoService.getOneMemo(1L);

        assertThat(foundMemo.getTitle()).isEqualTo("타이틀");
        assertThat(foundMemo.getContents()).isEqualTo("콘텐츠");
    }

    @Test
    @DisplayName("해당 ID값을 가진 메모를 수정해야 한다.")
    void 메모_수정하기() {
        Memo memo = new Memo("타이틀", "콘텐츠");
        MemoDto.Request updateRequestDto = new MemoDto.Request("new 타이틀", "new 콘텐츠");

        given(memoRepository.findById(any(Long.class))).willReturn(Optional.of(memo));

        MemoDto.Response updatedMemo = memoService.updateOneMemo(1L, updateRequestDto);

        assertThat(updatedMemo.getTitle()).isEqualTo("new 타이틀");
        assertThat(updatedMemo.getContents()).isEqualTo("new 콘텐츠");
    }

    @Test
    @DisplayName("해당 ID값을 가진 메모를 삭제한다.")
    void 메모_삭제하기() {
        Memo memo = new Memo("타이틀", "콘텐츠");

        given(memoRepository.findById(any(Long.class))).willReturn(Optional.of(memo));
        given(memoRepository.save(any(Memo.class))).willReturn(memo);

        MemoDto.Response removedMemo = memoService.removeOneMemo(1L);

        assertThat(removedMemo.isDeleted()).isTrue();
        verify(memoRepository).save(memo);
    }
}
