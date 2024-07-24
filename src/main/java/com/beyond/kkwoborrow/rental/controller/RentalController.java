//import com.beyond.kkwoborrow.rental.entity.Rental;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.Parameter;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@RestController
//@RequestMapping("/v1/rent")
//@Tag(name = "Rent APIs", description = "렌탈 관련 API 목록")
//@RequiredArgsConstructor
//
//public class RentalController {
//    private final RentalService rentalService;
//
//    @GetMapping("/rental")
//    @Operation(summary = "대여 신청", description = "대여 가능한 물품의 목록을 조회한다.")
//    public ResponseEntity<Rental> getRentByReturn(
//            @Parameter(description = "대여 가능 여부", example = "Y / N")
//            @RequestParam boolean isReturn, @RequestParam int PostID, @RequestParam LocalDateTime RentalDate, @RequestParam LocalDateTime ReturnDate) {
//        List<Rental> rent = rentalService.getRentByReturn(isReturn);
//
//        if (isReturn) { // 대여가 가능하면 대여 가능한 물품들 리스트 나오도록 하는거
//            // return ResponseEntity.ok(new RentalRepository<>(HttpStatus.OK, rent));
//            return rentalService.getRentByReturn(isReturn, PostID, RentalDate, ReturnDate); // 이렇게 하면 대여 가능 여부, 게시글 아이디, 반납 날짜가 나오지 않을까 생각합니다....
//        } else { // 다른 사람이 이미 대여를 하고 있으면 남은 기간 보여주게 하고 싶은데 코드를 못짜겠....
//            return rentalService.getRentByReturn(isReturn, PostID, ReturnDate);
//        }
//    }
//
//    @PostMapping("/rental")
//    @Operation(summary = "반납 신청", description = "대여한 물품을 반납")
//    public ResponseEntity<Rental> createRental(
//            @Parameter(description = "반납 신청")
//            @RequestParam Long TransactionID, @RequestParam int PostID, @RequestParam boolean isReturn) {
//        List<Rental> rent = rentalService.createRental(TransactionID); // 아이디를 통해서 반납 신청을 한다.
//
//        if (rentalService.TransactionID != TransactionID) { // 만약에 렌트했던 아이디가 다르면 반납 신청이 안된다. (에러 메세지 띄우고 싶은뎅...)
//            return ResponseEntity.notFound().build();
//        } else { // 만약에 렌트했던 아이디가 같으면 반납 신청이 된다.
//            return rentalService.createRental(TransactionID, PostID, isReturn); // 그냥 isReturn만 나와도 괜찮은건가..?
//        }
//    }