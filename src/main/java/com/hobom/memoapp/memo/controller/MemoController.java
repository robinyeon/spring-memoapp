package com.hobom.memoapp.memo.controller;

import com.hobom.memoapp.memo.dto.MemoDto;
import com.hobom.memoapp.memo.service.MemoService;
import com.hobom.memoapp.url.Urls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Urls.MemoUrl.BASE_URL)
public class MemoController {

    @Autowired
    private MemoService memoService;

    @PostMapping
    public MemoDto.Response createOneMemo(@RequestBody MemoDto.Request memoCreateRequestDto) {
        return memoService.createOneMemo(memoCreateRequestDto);
    }

    @GetMapping(Urls.MemoUrl.ID_PARAM)
    public MemoDto.Response getOneMemo(@PathVariable Long id) {
        return memoService.getOneMemo(id);
    }

    @GetMapping
    public List<MemoDto.Response> getAllMemo() {
        return memoService.getAllMemo();
    }

    @PatchMapping(Urls.MemoUrl.ID_PARAM)
    public MemoDto.Response updateOneMemo(@PathVariable Long id, @RequestBody MemoDto.Request memoUpdateRequestDto) {
        return memoService.updateOneMemo(id, memoUpdateRequestDto);
    }

    @DeleteMapping(Urls.MemoUrl.ID_PARAM)
    public MemoDto.Response removeOneMemo(@PathVariable Long id) {
        return memoService.removeOneMemo(id);
    }

}
