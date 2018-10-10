package com.llz.mp.metaObject;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

public class MyMetaObjectHandler extends MetaObjectHandler {
    //插入操作自动填充
    @Override
    public void insertFill(MetaObject metaObject) {
        //获取需要被填充的字段
        Object fieldValue = getFieldValByName("name",metaObject);
        if(null == fieldValue){
            setFieldValByName("name","autoinsert",metaObject);
        }
    }
    //更新操作自动填充
    @Override
    public void updateFill(MetaObject metaObject) {
        //获取需要被填充的字段
        Object fieldValue = getFieldValByName("name",metaObject);
        if(null == fieldValue){
            setFieldValByName("name","autoupdate",metaObject);
        }
    }
}
