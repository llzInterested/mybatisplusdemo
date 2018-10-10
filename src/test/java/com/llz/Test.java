package com.llz;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.llz.mp.entity.User;
import com.llz.mp.mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    private UserMapper userMapper = ioc.getBean("userMapper",UserMapper.class);
    @org.junit.Test
    public void testDataSource() throws SQLException {
        DataSource ds = ioc.getBean("dataSource",DataSource.class);
        System.out.println(ds);

        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
    /**
     * 通用insert
     */
    @org.junit.Test
    public void testCommonInsert(){
        User user = new User(1,"小王",24,"0",200);
        Integer result = userMapper.insert(user);
        System.out.println("result="+result);
    }
//    代码生成器示例代码
    @org.junit.Test
    public void testGenerator(){
        //1.全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true)   //是否支持AR模式
            .setAuthor("llz")           //作者
            .setOutputDir("C:\\study\\IDEAWorkspaces\\mybatisplusdemo\\src\\main\\java")   //生成路径
            .setFileOverride(true)      //文件覆盖，第二次生成的覆盖第一次的
            .setIdType(IdType.AUTO)     //主键策略,自增主键
            .setServiceName("%sService")         //设置生成的service接口的名字的首字母是否为I,%sService是不为I
            .setBaseResultMap(true)         //生成基本的resultMap
            .setBaseColumnList(true);        //生成基本的sql片段
        //2.数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)        //设置数据库类型
            .setDriverName("com.mysql.jdbc.Driver")
            .setUrl("jdbc:mysql://localhost:3306/test")
            .setUsername("root")
            .setPassword("llz721097");
        //3.策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true)       //全局大写命名
            .setDbColumnUnderline(true)     //指定表名，字段名是否使用下划线
            .setNaming(NamingStrategy.underline_to_camel)       //数据库表映射到实体下划线转驼峰
            .setTablePrefix("test_")        //指定表前缀
            .setInclude("user");        //生成的表
        //4.包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.llz.mp")    //设置父包名
            .setMapper("mapper")        //mapper存放位置com.llz.mp.mapper，下同
            .setService("service")
            .setController("controller")
            .setEntity("entity")
            .setXml("mapper");
        //5.整合配置
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(config).setDataSource(dsConfig).setStrategy(stConfig).setPackageInfo(pkConfig);
        //6.执行
        ag.execute();
    }
    //测试自定义全局操作
    @org.junit.Test
    public void testMySqlInjector(){
        Integer result = userMapper.deleteAll();
        System.out.println(result);
    }
}
