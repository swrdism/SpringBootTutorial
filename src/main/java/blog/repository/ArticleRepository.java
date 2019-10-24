package blog.repository;

import blog.model.Article;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
    @Transactional
    @Modifying
    @Query(value = "Truncate table article", nativeQuery = true)
    void truncate();
}
