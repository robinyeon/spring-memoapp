package com.hobom.memoapp.memo.controller;

import com.hobom.memoapp.dto.ApiResponse;
import com.hobom.memoapp.memo.dto.MemoDto;
import com.hobom.memoapp.memo.service.MemoService;
import com.hobom.memoapp.url.Urls;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Urls.MemoUrl.BASE_URL)
public class MemoController {

    @Autowired
    private MemoService memoService;

    @PostMapping
    public ResponseEntity<ApiResponse<MemoDto.Response>> createOneMemo(@RequestBody @Valid MemoDto.Request memoCreateRequestDto) {
        MemoDto.Response responseDto = memoService.createOneMemo(memoCreateRequestDto);
        return ResponseEntity.ok(ApiResponse.of(HttpStatus.OK, "메모 생성 성공", responseDto));
    }

    @GetMapping(Urls.ID_PARAM)
    public ResponseEntity<ApiResponse<MemoDto.Response>> getOneMemo(@PathVariable Long id) {
        MemoDto.Response responseDto = memoService.getOneMemo(id);
        return ResponseEntity.ok(ApiResponse.of(HttpStatus.OK, "메모 한개 조회 성공", responseDto));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<MemoDto.Response>>> getAllMemo() {
        List<MemoDto.Response> responseDto = memoService.getAllMemo();
        return ResponseEntity.ok(ApiResponse.of(HttpStatus.OK, "전체 메모 조회 성공", responseDto));
    }

    @PatchMapping(Urls.ID_PARAM)
    public ResponseEntity<ApiResponse<MemoDto.Response>> updateOneMemo(@PathVariable Long id, @RequestBody @Valid MemoDto.Request memoUpdateRequestDto) {
        MemoDto.Response responseDto = memoService.updateOneMemo(id, memoUpdateRequestDto);
        return ResponseEntity.ok(ApiResponse.of(HttpStatus.OK, "메모 수정 성공", responseDto));
    }

    @DeleteMapping(Urls.ID_PARAM)
    public ResponseEntity<ApiResponse<MemoDto.Response>> removeOneMemo(@PathVariable Long id) {
        MemoDto.Response responseDto = memoService.removeOneMemo(id);
        return ResponseEntity.ok(ApiResponse.of(HttpStatus.OK, "메모 삭제 성공", responseDto));
    }

}
