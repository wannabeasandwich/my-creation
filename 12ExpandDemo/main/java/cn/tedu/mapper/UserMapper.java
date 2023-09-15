package cn.tedu.mapper;

import cn.tedu.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMapper extends JpaRepository<User,Integer> {
}
