package com.llz.mp.injector;

import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.mapper.AutoSqlInjector;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

public class MySqlInjector extends AutoSqlInjector {
    @Override
    public void inject(Configuration configuration, MapperBuilderAssistant builderAssistant, Class<?> mapperClass, Class<?> modelClass, TableInfo table) {
        //将UserMapper中定义的deleteAll，处理成对应的mapperedStatement对象，加入configuration对象中
        //注入的sql
        String sql = "delete from " + table.getTableName();
        //注入的方法名,与mapper接口中方法名一致
        String method = "deleteAll";
        SqlSource sqlSource = languageDriver.createSqlSource(configuration,sql,modelClass);
        this.addDeleteMappedStatement(mapperClass,method,sqlSource);
    }
}
