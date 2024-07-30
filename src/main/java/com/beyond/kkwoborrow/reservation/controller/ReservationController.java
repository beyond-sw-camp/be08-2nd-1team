package com.beyond.kkwoborrow.reservation.controller;

import com.beyond.kkwoborrow.reservation.dto.ReservationRequestDto;
import com.beyond.kkwoborrow.reservation.dto.ReservationResponseDto;
import com.beyond.kkwoborrow.reservation.dto.ReservationsResponseDto;
import com.beyond.kkwoborrow.reservation.service.ReservationService;
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
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@Tag(name = "Reservations APIs", description = "예약 관련 API 목록")
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Operation(summary = "예약 조회", description = "reserveId로 예약을 조회한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ReservationResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @Parameter(name = "reserveId", description = "예약 ID", example = "1")
    @GetMapping("/{reserveId}")
    public ResponseEntity<ReservationResponseDto> getReservation(@PathVariable Long reserveId) {
        try {
            ReservationResponseDto reservationResponseDto = reservationService.getReservation(reserveId);
            return new ResponseEntity<>(reservationResponseDto, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "예약 목록 조회", description = "모든 예약 목록을 조회한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ReservationsResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호", example = "1"),
            @Parameter(name = "numOfRows", description = "한 페이지 결과 수", example = "10")
    })
    @GetMapping
    public ResponseEntity<ReservationsResponseDto> getAllReservations(@RequestParam int page, @RequestParam int numOfRows) {
        if (page <= 0 || numOfRows <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        int totalCount = reservationService.getTotalCount();
        if ((page - 1) * numOfRows >= totalCount) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<ReservationResponseDto> reservations = reservationService.getAllReservations(page, numOfRows, totalCount);
        ReservationsResponseDto response = new ReservationsResponseDto(reservations, page, numOfRows, totalCount);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "예약 생성", description = "새로운 예약을 생성한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ReservationResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @PostMapping
    public ResponseEntity<ReservationResponseDto> createReservation(@RequestBody ReservationRequestDto reservationRequestDto) {
        try {
            ReservationResponseDto reservationResponseDto = reservationService.save(reservationRequestDto);
            return new ResponseEntity<>(reservationResponseDto, HttpStatus.CREATED);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "예약 삭제", description = "reserveId로 예약을 삭제한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @Parameter(name = "reserveId", description = "예약 ID", example = "1")
    @DeleteMapping("/{reserveId}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long reserveId) {
        try {
            reservationService.deleteReservation(reserveId);
            return new ResponseEntity<>(HttpStatus.OK); // 삭제 성공 시 200 OK
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 잘못된 요청 시 400 Bad Request
        }
    }
}
