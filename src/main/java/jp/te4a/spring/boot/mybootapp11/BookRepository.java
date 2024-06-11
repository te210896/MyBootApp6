package jp.te4a.spring.boot.mybootapp11;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.concurrent.ConcurrentHashMap;
// import java.util.concurrent.ConcurrentMap;
// import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookBean, Integer>{
        
}