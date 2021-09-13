package org.hsl.sample_api.controller;

import org.hsl.sample_api.service.UserService;
import org.hsl.sample_api.utils.ValidationUtils;
import org.hsl.sample_api.vo.UserVO;
import java.util.List;
import javax.validation.constraints.NotBlank;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 모든 회원정보 조회
     *
     * @return
     */
    @GetMapping(value = "/users", produces = "application/json")
    public ResponseEntity getUsers() {
        List<UserVO> userList = this.userService.getUsers();
        HttpStatus httpStatus = (CollectionUtils.isEmpty(userList)) ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return new ResponseEntity(userList, httpStatus);
    }

    /**
     * 회원정보 조회
     *
     * @param no
     * @return
     */
    @GetMapping(value = "/{no}", produces = "application/json")
    public ResponseEntity getUser(@PathVariable(value = "no") int no) {
        UserVO currentUserVO = this.userService.findUserByNo(no);
        return new ResponseEntity(currentUserVO, HttpStatus.OK);
    }

    /**
     * 회원 가입
     *
     * @param email
     * @param name
     * @param passwd
     * @return
     */
    @PostMapping("/join")
    public ResponseEntity joinUser(
        @NotBlank(message = "이메일이 입력되지 않았습니다!") @RequestParam String email,
        @NotBlank(message = "이름이 입력되지 않았습니다!") @RequestParam String name,
        @NotBlank(message = "비밀번호가 입력되지 않았습니다!") @RequestParam String passwd) {
        userService.joinUser(email, name, passwd);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * 비밀번호 변경
     *
     * @param no
     * @param changePasswd
     * @return
     */
    @PostMapping("/update_passwd/{no}")
    public ResponseEntity updateUserPasswd(
        @PathVariable(value = "no") int no,
        @NotBlank(message = "변경할 비밀번호가 입력되지 않았습니다!") String changePasswd) {
        userService.updatePasswd(no, changePasswd);
        return new ResponseEntity("비밀번호가 변경되었습니다", HttpStatus.OK);
    }

    /**
     * 회원정보 삭제
     *
     * @param no
     * @return
     */
    @PostMapping("/delete/{no}")
    public ResponseEntity deleteUser(
        @PathVariable(value = "no") int no) {
        userService.deleteUser(no);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
