package com.yl.dbtest.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.*;

/**
 * Created by Administrator on 2016/4/6.
 * list: 待插入集合的@Param注解名称, 在内部解析时会用到
 * tableName: 待插入表的 @Param注解名称, 在内部解析时会用到
 * col2property: 表字段和对象属性的对应关系; LinkedHashMap 类型的
 */
public class BatchInsertMapperProviderV1<E> {
    private static final Logger LOG = LoggerFactory.getLogger(BatchInsertMapperProviderV1.class);
    private static final String KEY_TABLENAME = "tableName";  // 和@Param注解名称保持一致
    private static final String KEY_LIST = "list";  // 和@Param注解名称保持一致
    private static final String KEY_COL2PROPERTY = "col2property";  // 和@Param注解名称保持一致

    public String batchInsert(Map map) {
        Set<String> sets = map.keySet();
        for(String ele: sets){
            LOG.info("BatchInsertMapperProvider ele, {}:{}", ele, map.get(ele) );
        }

        // 获取表名
        String tableName = (String) map.get(KEY_TABLENAME);
        LOG.info("BatchInsertMapperProvider tableName:{}", tableName);

        // 获取字段和属性的对应关系
        StringBuilder sbFields = new StringBuilder();
        StringBuilder sbProperty = new StringBuilder();
        // 带上最前面的括号, 字段部分目标:(id, name, age);
        // Values 部分目标:"(#'{'param1[{0}].id},#'{'param1[{0}].name},#'{'param1[{0}].age})"
        sbFields.append("  (");  // 加上括号，避免和表名紧挨着了
        sbProperty.append("(");
        LinkedHashMap<String, String> col2property = (LinkedHashMap<String, String>) map.get(KEY_COL2PROPERTY);
        final int FIELDS = col2property.size();
        LOG.info("BatchInsertMapperProvider FIELDS:{}", FIELDS);
        Set<Map.Entry<String, String> > entries = col2property.entrySet();
        int i = 0;
        for(Map.Entry<String, String> ele: entries){
            String column = ele.getKey();
            String property = ele.getValue();
            LOG.info("BatchInsertMapperProvider, column:{}, property:{}", column, property);
            sbFields.append(column);
            sbProperty.append("#'{'list[{0}]." + property + "}");

            if (i < FIELDS - 1) {
                sbFields.append(",");
                sbProperty.append(",");
            }

            ++i;
        }
        sbFields.append(")");  // 补上右边的括号
        sbProperty.append(")");  // 补上右边的括号

        LOG.info("BatchInsertMapperProvider fieldsSql:{}", sbFields.toString() );
        LOG.info("BatchInsertMapperProvider propertySql:{}", sbProperty.toString() );

        // 构造插入语句
        StringBuilder sbSql = new StringBuilder();
        sbSql.append("INSERT INTO ");
        sbSql.append(tableName);
        sbSql.append(sbFields.toString());
        sbSql.append(" VALUES ");

        MessageFormat mf = new MessageFormat(sbProperty.toString());

        List<E> data = (ArrayList<E>) map.get(KEY_LIST);  // 类型信息是怎么传递进去的, 不需要类型信息，有个 SIZE 就行了
        // List<E> data = (List<E>) map.get(KEY_LIST);  // 类型信息是怎么传递进去的, 不需要类型信息，有个 SIZE 就行了
        final Integer DATA_SIZE = data.size();
        LOG.info("BatchInsertMapperProvider DATA_SIZE:{}", DATA_SIZE);
        for (int j = 0; j < data.size(); j++) {
            sbSql.append( mf.format(new Object[]{j}) );
            if (j < DATA_SIZE - 1) {
                sbSql.append(",");
            }
        }

        String sql = sbSql.toString();
        LOG.info("BatchInsertMapperProvider sql:{}", sql);
        return sql;
    }
}
