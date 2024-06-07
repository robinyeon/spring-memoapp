package com.hobom.memoapp.memo;

import com.hobom.memoapp.memo.dto.MemoCreateRequestDto;
import com.hobom.memoapp.memo.dto.MemoUpdateRequestDto;
import com.hobom.memoapp.memo.entity.Memo;
import com.hobom.memoapp.memo.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/memos")
public class MemoController {

    @Autowired
    private MemoService memoService;

    /**
     * 메모 생성
     */
    @PostMapping()
    public Memo createOneMemo(@RequestBody MemoCreateRequestDto memoCreateRequestDto) {
        return memoService.createOneMemo(memoCreateRequestDto);
    }

    /**
     * 메모 한개 조회
     */
    @GetMapping("/{id}")
    public Memo getOneMemo(@PathVariable Long id) {
        return memoService.getOneMemo(id);
    }

    /**
     * 전체 메모 조회
     */
    @GetMapping()
    public List<Memo> getAllMemo() {
        return memoService.getAllMemo();
    }

    /**
     * 메모 수정
     */
    @PatchMapping("/{id}")
    public Memo updateOneMemo(@PathVariable Long id, @RequestBody MemoUpdateRequestDto memoUpdateRequestDto) {
        return memoService.updateOneMemo(id, memoUpdateRequestDto);
    }

    /**
     * 메모 삭제
     */
    @DeleteMapping("/{id}")
    public void removeOneMemo(@PathVariable Long id) {
        memoService.removeOneMemo(id);
    }

}
