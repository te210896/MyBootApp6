package jp.te4a.spring.boot.mybootapp8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    // nullを許容しないことでスレッドセーフにしているらしい。
    private final ConcurrentMap<Integer, BookBean> bookMap
                                    = new ConcurrentHashMap<>();
    
    private int BOOK_ID = 0;
    public int getBookId() {
        return BOOK_ID++;
    }

    public BookBean create(BookBean bookBean) {
        return bookMap.put(bookBean.getId(), bookBean);
    }

    public List<BookBean> findAll() {
        return new ArrayList<>(bookMap.values());
    }

    public BookBean findOne(Integer id) {
        return bookMap.get(id);
    }

    public BookBean update(BookBean srcBookBean) {
        BookBean tgtBookBean = bookMap.get(srcBookBean.getId());
        // srcBookBeanの全フィールドをtgtBookBeanにコピーする。
        BeanUtils.copyProperties(srcBookBean, tgtBookBean);
        return tgtBookBean;
    }

    public void delete(Integer bookId) {
        bookMap.remove(bookId);
    }
}