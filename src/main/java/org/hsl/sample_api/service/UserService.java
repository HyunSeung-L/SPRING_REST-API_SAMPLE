package org.hsl.sample_api.service;

import org.hsl.sample_api.exception.DeleteUserFailException;
import org.hsl.sample_api.exception.JoinUserFailException;
import org.hsl.sample_api.exception.NoUserDataException;
import org.hsl.sample_api.exception.UpdatePasswdFailException;
import org.hsl.sample_api.mapper.UserMapper;
import org.hsl.sample_api.vo.LoginVO;
import org.hsl.sample_api.vo.UserVO;
import java.util.List;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public UserVO loginUserCheck(LoginVO loginVO) {
        UserVO user = this.userMapper.findUserByEmailAndPasswd(loginVO);
        return user;
    }

    public List<UserVO> getUsers() {
        List<UserVO> users = this.userMapper.getUsers();
        return users;
    }

    public UserVO findUserByNo(int no) {
        UserVO resultVO = this.userMapper.findUserByNo(no);
        if (ObjectUtils.isEmpty(resultVO)) {
            throw new NoUserDataException(String.format("{%d}번 회원정보가 조회되지 않습니다", no));
        }

        return resultVO;
    }

    public void joinUser(String email, String name, String passwd) {
        // 이미 가입된 이메일인지 체크
        UserVO currentUserVO = this.userMapper.findUserByEmail(email);
        if (ObjectUtils.isNotEmpty(currentUserVO)) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        UserVO userVO = UserVO.builder().email(email).name(name).passwd(passwd).build();
        this.userMapper.joinUser(userVO);

        // 회원 가입이 성공했는지 확인
        UserVO joinUserVO = this.userMapper.findUserByEmail(email);
        if (ObjectUtils.isEmpty(joinUserVO)) {
            throw new JoinUserFailException(String.format("회원 가입에 실패했습니다"));
        }
    }

    public void updatePasswd(int no, String changePasswd) {
        // 회원 정보가 존재하는지 체크
        UserVO beforeUserVO = this.findUserByNo(no);
        String beforePasswd = beforeUserVO.getPasswd();

        if (StringUtils.equals(beforePasswd, changePasswd)) {
            throw new IllegalArgumentException(String.format("동일한 비밀번호입니다", no));
        }

        UserVO userVO = UserVO.builder().no(no).passwd(changePasswd).build();
        this.userMapper.updatePasswd(userVO);

        // 비밀번호가 변경되었는지 확인
        UserVO updatedUserVO = this.findUserByNo(no);
        if (StringUtils.equals(beforePasswd, updatedUserVO.getPasswd())) {
            throw new UpdatePasswdFailException(String.format("{%d}번 회원의 비밀번호가 변경되지 않았습니다", no));
        }
    }

    public void deleteUser(int no) {
        // 회원 정보가 존재하는지 체크
        this.findUserByNo(no);

        this.userMapper.deleteUser(no);

        // 회원 삭제가 성공했는지 확인
        UserVO resultVO = this.userMapper.findUserByNo(no);
        if (ObjectUtils.isNotEmpty(resultVO)) {
            throw new DeleteUserFailException(String.format("{%d}번 회원 정보가 삭제되지 않았습니다", no));
        }
    }
}
