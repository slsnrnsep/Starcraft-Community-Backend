package com.mini.miniproject.service;

import com.mini.miniproject.model.User;
import com.mini.miniproject.dto.UserDto;
import com.mini.miniproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserService (UserRepository userRepository, PasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public void registerUser(UserDto requestDto) {
        String userId = requestDto.getId();
        String password = requestDto.getPassword();
        String passwordConfirm = requestDto.getPasswordconfirm();
        String userNick = requestDto.getUserNick();

        boolean bcheck = check(userId, password, passwordConfirm,userNick);
        if(!bcheck)
        {
            throw new IllegalArgumentException("값을 확인해주세요");
        }
        User user = userRepository.findById(userId).orElse(null);
        if(user == null)
        {
            User newUser = new User(requestDto);
            newUser.setPassword(passwordEncoder.encode(requestDto.getPassword()));
            userRepository.save(newUser);
            // 회원가입 진행
        }
        else
        {
            throw new IllegalArgumentException("중복된 닉네임입니다.");
            //중복된거 있다고 알람창띄우가
        }
    }
    public User find(String id)
    {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    private boolean check(String userId, String password, String passwordConfirm, String userNick) {
        return true;
        //이건 협의후 진행.
//        String pwPattern = "^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z[0-9]]{4,}$";
//        boolean check = Pattern.matches(pwPattern,userId);
//        if(!check)
//        {
//            return false;
//        }
//        if(password.length() < 4 || password.contains(userNick))
//        {
//            return false;
//            //2. 최소 4글자 이상, 닉네임과 같은 값이 포함된 경우 실패. len,contains
//        }
//        if(!password.equals(passwordConfirm))
//        {
//            return false;
//        }

    }
}
