package cn.codingtalk.tacomallapiportal;

import java.util.List;
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.codingtalk.tacomallentity.member.Member;
import cn.codingtalk.tacomallmapper.member.MemberMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusTest {
    @Resource
    private MemberMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<Member> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
}
