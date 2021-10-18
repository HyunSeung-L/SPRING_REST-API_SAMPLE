package org.hsl.sample_api.mapper;

import org.hsl.sample_api.vo.LoginVO;
import org.hsl.sample_api.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface UserMapper {

    public ArrayList<UserVO> getUsers();

    public void joinUser(UserVO userVO);

    public UserVO findUserByEmail(String email);

    public UserVO findUserByEmailAndPasswd(LoginVO loginVO);

    public UserVO findUserByNo(int no);

    public void updatePasswd(UserVO userVO);

    public void deleteUser(int no);

}
