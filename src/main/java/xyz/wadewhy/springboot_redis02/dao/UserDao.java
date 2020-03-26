package xyz.wadewhy.springboot_redis02.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;
import xyz.wadewhy.springboot_redis02.entity.User;

@Transactional
public interface UserDao extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User>, JpaRepository<User,Long> {
    User findById(String id);
}
