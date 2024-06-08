package com.hobom.memoapp.memo.service;

import com.hobom.memoapp.memo.dto.MemoDto;

import java.util.List;

public interface MemoService {
    public MemoDto.Response createOneMemo(MemoDto.Request memoCreateRequestDto);

    public MemoDto.Response getOneMemo(Long id);

    public List<MemoDto.Response> getAllMemo();

    public MemoDto.Response updateOneMemo(Long id, MemoDto.Request memoUpdateRequestDto);

    public MemoDto.Response removeOneMemo(Long id);
}
