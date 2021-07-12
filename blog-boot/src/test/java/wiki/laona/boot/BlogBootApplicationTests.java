package wiki.laona.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wiki.laona.boot.mapper.ArticleMapper;
import wiki.laona.boot.mapper.CategoryMapper;
import wiki.laona.boot.mapper.CustomerMapper;
import wiki.laona.boot.pojo.dao.Article;
import wiki.laona.boot.pojo.dao.Category;
import wiki.laona.boot.pojo.dao.Customer;

import java.util.List;

@SpringBootTest
class BlogBootApplicationTests {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CustomerMapper customerMapper;

    @Test
    void contextLoads() {
        List<Article> articles = articleMapper.selectList(null);
        articles.forEach(System.out::println);

        List<Category> categories = categoryMapper.selectList(null);
        categories.forEach(System.out::println);

        List<Customer> customers = customerMapper.selectList(null);
        customers.forEach(System.out::println);
    }


    @Test
    void addCustomerTest() {
        Customer customer = new Customer();
        customer.setUsername("laona");
        customer.setPassword("123");
        customerMapper.insert(customer);
    }

}
