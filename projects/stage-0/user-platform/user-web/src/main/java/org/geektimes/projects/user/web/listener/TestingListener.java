package org.geektimes.projects.user.web.listener;

import org.geektimes.context.ComponentContext;
import org.geektimes.projects.user.domain.Computer;
import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.management.ComputerManager;
import org.geektimes.projects.user.management.UserManager;
import org.geektimes.projects.user.management.UserManagerMBean;
import org.geektimes.projects.user.sql.DBConnectionManager;

import javax.management.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.lang.management.ManagementFactory;
import java.util.logging.Logger;

/**
 * 测试用途
 */
@Deprecated
public class TestingListener implements ServletContextListener {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ComponentContext context = ComponentContext.getInstance();
        DBConnectionManager dbConnectionManager = context.getComponent("bean/DBConnectionManager");
        dbConnectionManager.getConnection();

//        testUser(dbConnectionManager.getEntityManager());

        testPropertyFromServletContext(sce.getServletContext());
        testPropertyFromJNDI(context);
        //testUser(dbConnectionManager.getEntityManager());

        logger.info("所有的 JNDI 组件名称：[");
        context.getComponentNames().forEach(logger::info);
        logger.info("]");

        try {


            // 获取平台 MBean Server
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
            // 为 UserMXBean 定义 ObjectName
//            ObjectName objectName = new ObjectName("org.geektimes.projects.user.management:type=User");

            ObjectName objectName = new ObjectName("jolokia:name=User");
            ObjectName objectName1 = new ObjectName("jolokia:name=Computer");
            // 创建 UserMBean 实例
            User user = new User();
            Computer computer=new Computer();
            mBeanServer.registerMBean(new UserManager(user), objectName);
            mBeanServer.registerMBean(new ComputerManager(computer), objectName1);

//            while (true) {
//                Thread.sleep(2000);
//                System.out.println(user);
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void testPropertyFromServletContext(ServletContext servletContext) {
        String propertyName = "application.name";
        logger.info("ServletContext Property[" + propertyName + "] : "
                + servletContext.getInitParameter(propertyName));
    }

    private void testPropertyFromJNDI(ComponentContext context) {
        String propertyName = "maxValue";
        logger.info("JNDI Property[" + propertyName + "] : "
                + context.lookupComponent(propertyName));
    }

    private void testUser(EntityManager entityManager) {
        User user = new User();
        user.setName("小马哥");
        user.setPassword("******");
        user.setEmail("mercyblitz@gmail.com");
        user.setPhoneNumber("abcdefg");
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
        System.out.println(entityManager.find(User.class, user.getId()));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
