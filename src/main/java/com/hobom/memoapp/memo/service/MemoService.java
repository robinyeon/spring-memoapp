package com.hobom.memoapp.memo.service;

import com.hobom.memoapp.memo.entity.Memo;
import com.hobom.memoapp.memo.repository.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("MemoService")
public class MemoService {

    @Autowired
    public MemoRepository memoRepository;

    public Memo createOneMemo(String title, String contents) {
        Memo createdMemo = new Memo(title, contents);
        return memoRepository.save(createdMemo);
    }

    public Memo getOneMemo(Long id) {
        return memoRepository.findById(id).orElseThrow(() -> new NullPointerException("Memo not found"));
    }

    public List<Memo> getAllMemo() {
        return memoRepository.findAll();
    }

    public Memo updateOneMemo(Long id, String title, String contents) {
        Memo foundMemo = getOneMemo(id);
        foundMemo.update(title, contents);
        return memoRepository.save(foundMemo);
    }

    // @Todo soft delete
    public void deleteOneMemo(Long id) {
        Memo foundMemo = this.getOneMemo(id);
        memoRepository.deleteById(id);
    }
}
