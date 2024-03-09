package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {
    /**
     * 회원 목록 조회: GET /users
     * 회원 등록: POST /users
     * 회원 조회: GET /users/{userId}
     * 회원 수정: PATCH /users/{userId}
     * 회원 삭제: DELETE /users/{userId}
     * @return
     */

    @GetMapping
    public String user() {
        return "get users";
    }

    @PostMapping
    public String addUser() {
        return "post user";
    }

    /**
     * 회원 1명 조회하기
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public String findUser(@PathVariable("userId") String userId) {
        return "get userId = " + userId;
    }

    /**
     * 회원 수정
     * @param userId
     * @return
     */
    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId){
        return "update userId = " + userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "delete userId = " + userId;
    }
}
