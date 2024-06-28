package org.redisCache.repository;

import org.redisCache.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo, Long> {
    List<UserInfo> findAllBy();

}
