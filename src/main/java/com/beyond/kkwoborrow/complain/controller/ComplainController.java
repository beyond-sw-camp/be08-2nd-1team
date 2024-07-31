package com.beyond.kkwoborrow.complain.controller;

import com.beyond.kkwoborrow.complain.dto.ComplainRequestDto;
import com.beyond.kkwoborrow.complain.dto.ComplainResponseDto;
import com.beyond.kkwoborrow.complain.dto.ComplainsResponseDto;
import com.beyond.kkwoborrow.complain.service.ComplainService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@Tag(name = "Complains APIs", description = "신고 관련 API 목록")
@RequestMapping("/api/v1/complain-service")
public class ComplainController {

    @Autowired
    private ComplainService complainService;

    @GetMapping("/complains/{complain-id}")
    @Operation(summary = "신고 조회", description = "complainId로 신고를 조회한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ComplainResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @Parameter(name = "complain-id", description = "신고 ID", example = "1")
    public ResponseEntity<ComplainResponseDto> getComplain(@PathVariable("complain-id") Long complainId) {
        try {
            ComplainResponseDto complainResponseDto = complainService.getComplain(complainId);
            return new ResponseEntity<>(complainResponseDto, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/complains")
    @Operation(summary = "신고 목록 조회", description = "모든 신고 목록을 조회한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ComplainsResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호", example = "1"),
            @Parameter(name = "numOfRows", description = "한 페이지 결과 수", example = "10")
    })
    public ResponseEntity<ComplainsResponseDto> getAllComplains(@RequestParam int page, @RequestParam int numOfRows) {
        if (page <= 0 || numOfRows <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        int totalCount = complainService.getTotalCount();
        if ((page - 1) * numOfRows >= totalCount) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<ComplainResponseDto> complains = complainService.getAllComplains(page, numOfRows, totalCount);
        ComplainsResponseDto response = new ComplainsResponseDto(complains, page, numOfRows, totalCount);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/complains")
    @Operation(summary = "신고 생성", description = "새로운 신고를 생성한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ComplainResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    public ResponseEntity<ComplainResponseDto> createComplain(@RequestBody ComplainRequestDto complainRequestDto) {
        try {
            ComplainResponseDto complainResponseDto = complainService.save(complainRequestDto);
            return new ResponseEntity<>(complainResponseDto, HttpStatus.CREATED);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/complains/{complain-id}")
    @Operation(summary = "신고 삭제", description = "complainId로 신고를 삭제한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @Parameter(name = "complain-id", description = "신고 ID", example = "1")
    public ResponseEntity<Void> deleteComplain(@PathVariable("complain-id") Long complainId) {
        try {
            complainService.deleteComplain(complainId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}