package com.hobom.memoapp.memo.service;

import com.hobom.memoapp.memo.dto.MemoCreateRequestDto;
import com.hobom.memoapp.memo.dto.MemoUpdateRequestDto;
import com.hobom.memoapp.memo.entity.Memo;
import com.hobom.memoapp.memo.repository.MemoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MemoService")
public class MemoService {

    @Autowired
    private MemoRepository memoRepository;

    public Memo createOneMemo(MemoCreateRequestDto memoCreateRequestDto) {
        Memo createdMemo = new Memo(memoCreateRequestDto.getTitle(), memoCreateRequestDto.getContents());
        return memoRepository.save(createdMemo);
    }

    public Memo getOneMemo(Long id) {
        Memo foundMemo = memoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Memo not found"));
        if(foundMemo.isDeleted()) throw new IllegalStateException("Memo has been already deleted.");
        return foundMemo;
    }

    public List<Memo> getAllMemo() {
        return memoRepository.findByDeletedIsFalse();
    }

    public Memo updateOneMemo(Long id, MemoUpdateRequestDto memoUpdateRequestDto) {
        Memo foundMemo = getOneMemo(id);
        foundMemo.update(memoUpdateRequestDto.getTitle(), memoUpdateRequestDto.getContents());
        return memoRepository.save(foundMemo);
    }

    // @Todo soft delete
    public Memo removeOneMemo(Long id) {
        Memo foundMemo = getOneMemo(id);
        foundMemo.setDeleted(true);
        return memoRepository.save(foundMemo);
    }
}
