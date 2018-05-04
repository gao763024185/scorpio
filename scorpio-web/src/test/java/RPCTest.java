import com.gao.scorpio.rpc.GetAllMenuRPC;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.Resource;

/**
 * @description 远程调用测试类
 * @author: gaobh
 * @date: 2018/4/12 9:57
 * @version: v1.0
 */
public class RPCTest {
    @Resource
    private GetAllMenuRPC getAllMenuRPC;


    public static void main(String[] args){
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:rpc-consumer.xml");
        ctx.refresh();
        GetAllMenuRPC getAllMenuRPC = ctx.getBean("remoteMenuService",GetAllMenuRPC.class);
        getAllMenuRPC.getAllMenu();
        System.out.println(888);
    }
}
