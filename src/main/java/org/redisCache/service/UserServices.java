package org.redisCache.service;

import lombok.AllArgsConstructor;
import org.redisCache.entity.UserInfo;
import org.redisCache.repository.UserInfoRepo;
import org.redisCache.util.constants.CacheNames;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserServices {
    private UserInfoRepo userInfoRepo;
    private CacheManager cacheManager;
    @Cacheable(CacheNames.USER_INFO)
    public List<UserInfo> getAllUsers(){
        System.out.println("Read user data from db ...");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return userInfoRepo.findAllBy();
    }

    @Cacheable(value = "#id")
    public UserInfo findUserById(Long id){
        List<UserInfo> userInfoList = cacheManager.getCache(CacheNames.USER_INFO).get(CacheNames.USER_INFO, List.class);
        return userInfoList == null ? null : userInfoList.stream().filter(userInfo -> userInfo.getId() == id).findFirst().orElse(null);
    }
}
