package shop.mtcoding.projoctbodykey.bodydata;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BodyDataJPARepository extends JpaRepository<BodyData, Integer> {

    @Query("""
            select a
            from Activity a
            join fetch a.user
            where a.user.id = :userId 
            order by a.createdAt desc
            """)
    Optional<List<BodyData>> findBodySevenByUserId(@Param("userId") Integer userId, Pageable pageable);

    @Query("select b from BodyData b where b.user.id = :userId order by b.createdAt desc limit 1")
    BodyData findByUserIdOrderDesc(@Param("userId") Integer userId);

    @Query("select b from BodyData b where b.user.id = :userId")
    List<BodyData> findByUserId(@Param("userId") Integer userId);

    @Query("select b from BodyData b where b.user.id = :userId order by b.id desc")
    List<BodyData> findByUserIdDesc(@Param("userId") Integer userId);
}
