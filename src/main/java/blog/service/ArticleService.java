package blog.service;

import blog.model.Article;
import blog.repository.ArticleRepository;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class ArticleService{

    @Resource
    private ArticleRepository articleRepository;

    public Article getArticle(int id) throws Exception {
        return articleRepository.findById(id)
                .orElseThrow(() -> new Exception("Can't find article."));
    }

    public void createArticle(Article article)  {
        articleRepository.save(article);
    }

    public void modifyArticle(int id, Article article){
        article.setId(id);
        articleRepository.save(article);
    }

    public void deleteArticle(int id) {
        articleRepository.deleteById(id);
    }

}
