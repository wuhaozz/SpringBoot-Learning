package com.wuhaozz.domain;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User, Long> {

    //    @Cacheable(key = "#p0", condition = "#p0.length() < 10")
    @Cacheable
    User findByName(String name);

}
