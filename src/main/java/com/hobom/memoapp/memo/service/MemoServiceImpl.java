package com.hobom.memoapp.memo.service;

import com.hobom.memoapp.memo.dto.MemoDto;
import com.hobom.memoapp.memo.entity.Memo;
import com.hobom.memoapp.memo.repository.MemoRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@Service("MemoService")
public class MemoServiceImpl implements MemoService {

    @Autowired
    private MemoRepository memoRepository;

    @Override
    @Transactional
    public MemoDto.Response createOneMemo(MemoDto.Request memoCreateRequestDto) {
        isTitleValid(memoCreateRequestDto.getTitle());

        Memo createdMemo = memoRepository.save(memoCreateRequestDto.toEntity());

        return MemoDto.Response.from(createdMemo);
    }

    @Override
    public MemoDto.Response getOneMemo(Long id) {
        Memo foundMemo = getOneMemoById(id);

        return MemoDto.Response.from(foundMemo);
    }

    @Override
    public List<MemoDto.Response> getAllMemo() {
        return memoRepository.findByDeletedIsFalse().stream().map(MemoDto.Response::from).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MemoDto.Response updateOneMemo(Long id, MemoDto.Request memoUpdateRequestDto) {
        Memo foundMemo = getOneMemoById(id);

        isTitleValid(memoUpdateRequestDto.getTitle());

        foundMemo.update(memoUpdateRequestDto.getTitle(), memoUpdateRequestDto.getContents());

        return MemoDto.Response.from(memoRepository.save(foundMemo));
    }

    @Override
    @Transactional
    public MemoDto.Response removeOneMemo(Long id) {
        Memo foundMemo = getOneMemoById(id);

        foundMemo.setDeleted(true);

        return MemoDto.Response.from(memoRepository.save(foundMemo));
    }

    private Memo getOneMemoById(Long id) {
        Memo foundMemo = memoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Memo not found"));

        if (foundMemo.isDeleted()) {
            throw new IllegalStateException("Memo has been already deleted.");
        }

        return foundMemo;
    }

    private void isTitleValid(String title) {
        Optional<Memo> foundMemo = memoRepository.findByTitle(title);

        if (foundMemo.isPresent()) {
            throw new EntityExistsException("Same memo title already exists.");
        }
    }
}
