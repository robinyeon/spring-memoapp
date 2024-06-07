package com.hobom.memoapp.memo.service;

import com.hobom.memoapp.memo.dto.MemoCreateRequestDto;
import com.hobom.memoapp.memo.dto.MemoUpdateRequestDto;
import com.hobom.memoapp.memo.entity.Memo;
import com.hobom.memoapp.memo.repository.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("MemoService")
public class MemoService {

    @Autowired
    private MemoRepository memoRepository;

    public Memo createOneMemo(MemoCreateRequestDto memoCreateRequestDto) {
        Memo createdMemo = new Memo(memoCreateRequestDto.getTitle(), memoCreateRequestDto.getContents());
        return memoRepository.save(createdMemo);
    }

    public Memo getOneMemo(Long id) {
        return memoRepository.findById(id).orElseThrow(() -> new NullPointerException("Memo not found"));
    }

    public List<Memo> getAllMemo() {
        return memoRepository.findAll();
    }

    public Memo updateOneMemo(Long id, MemoUpdateRequestDto memoUpdateRequestDto) {
        Memo foundMemo = getOneMemo(id);
        foundMemo.update(memoUpdateRequestDto.getTitle(), memoUpdateRequestDto.getContents());
        return memoRepository.save(foundMemo);
    }

    // @Todo soft delete
    public void removeOneMemo(Long id) {
        this.getOneMemo(id);
        memoRepository.deleteById(id);
    }
}
