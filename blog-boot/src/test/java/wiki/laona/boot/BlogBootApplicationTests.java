package wiki.laona.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wiki.laona.boot.mapper.ArticleMapper;
import wiki.laona.boot.pojo.Article;

import java.util.List;

@SpringBootTest
class BlogBootApplicationTests {

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void contextLoads() {
        List<Article> articles = articleMapper.selectList(null);
        articles.forEach(System.out::println);
    }

}
