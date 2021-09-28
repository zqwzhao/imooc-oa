import com.imooc.oa.utils.MyBatisUtils;
import org.junit.Test;

/**
 * @author : [zqwzh]
 * @version : [v1.0]
 * @createTime : [2021-09-16 22:16]
 */
public class MyBatisUtilsTest {
    @Test
    public void testCase1() {
        String result = (String)MyBatisUtils.executeQuery(sqlSession -> {
            String str = (String)sqlSession.selectOne("test.sample");
            return str;
        });
    }


    @Test
    public void testCase2() {
        String str = (String) MyBatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("test.sample"));
        System.out.println(str);
    }
}
