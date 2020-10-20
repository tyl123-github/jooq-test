package com.test.config.generator;

import org.apache.commons.lang3.StringUtils;
import org.jooq.codegen.GenerationTool;
import org.jooq.codegen.JavaGenerator;
import org.jooq.meta.jaxb.*;

public class JOOQGenerator extends JavaGenerator {


    /**
     * 数据库驱动
     */
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    /**
     * 数据库连接url
     */
    private static final String JDBC_URL = "jdbc:mysql://192.168.5.66:3306";
    /**
     * 数据库账号
     */
    private static final String JDBC_USERNAME = "root";
    /**
     * 数据库密码
     */
    private static final String JDBC_PASSWORD = "Zzwl@2020";

    /**
     * 数据库类型  mysql
     */
    private static final String JOOQ_DATABASE_NAME = "org.jooq.meta.mysql.MySQLDatabase";

    /**
     * 生成代码path
     */
    private static final String GENERATOR_PATH = "src/main/java";


    /**
     * orm逆向生成pojo
     *
     * @param schemaName  表名称
     * @param packageName 包名称
     * @param includes    包含表
     * @param excludes    过滤表
     * @throws Exception
     */
    public static void genTables(String schemaName, String packageName, String includes, String excludes) throws Exception {
        Jdbc jdbc = createJdbc();
        Generator generator = createGenerator(schemaName, packageName, includes, excludes);

        Configuration configuration = new Configuration()
                .withJdbc(jdbc)
                .withGenerator(generator);

        GenerationTool.generate(configuration);
    }

    /**
     * createGenerator
     *
     * @param schemaName  数据库名称
     * @param packageName 包名
     * @param includes    包含表
     * @param excludes    过滤表
     * @return
     */
    private static Generator createGenerator(String schemaName, String packageName, String includes, String excludes) {

        Database database = createDatabase(schemaName, includes, excludes);
        Target target = createTarget(packageName);
        Generate generate = createGenerate();

        return new Generator()
                .withDatabase(database)
                .withTarget(target)
                .withGenerate(generate);
    }

    /**
     * 数据库连接配置  创建数据库连接
     *
     * @return
     */
    private static Jdbc createJdbc() {
        return new Jdbc()
                .withDriver(JDBC_DRIVER)
                .withUrl(JDBC_URL)
                .withUser(JDBC_USERNAME)
                .withPassword(JDBC_PASSWORD);
    }

    /**
     * createTarget
     *
     * @param packageName 生成的代码存放的包名
     * @return
     */
    private static Target createTarget(String packageName) {

        return new Target()
                .withDirectory(GENERATOR_PATH)
                .withPackageName(packageName);
    }


    /**
     * createDatabase
     *
     * @param schemaName 数据库名
     * @param includes   包含哪些表
     * @param excludes   排除哪些表，这里支持正则表达式 ，多个条件可以用 | 连接符连接
     * @return
     */
    private static Database createDatabase(String schemaName, String includes, String excludes) {
        Database database = new Database()
                .withName(JOOQ_DATABASE_NAME)
                .withInputSchema(schemaName);
        if (StringUtils.isNotBlank(includes)) {
            database.withIncludes(includes);
        }

        if (StringUtils.isNotBlank(excludes)) {
            database.withExcludes(excludes);
        }
        return database;
    }


    /**
     * 创建生成数据Generate 定义生成数据
     *
     * @return
     */
    private static Generate createGenerate() {
        Generate generate = new Generate();
        generate.withDaos(Boolean.TRUE)//生成dao
                .withPojos(Boolean.TRUE)//生成pojo
                .withJavaTimeTypes(Boolean.TRUE)//时间使用java8时间localDateTime
                .withSpringAnnotations(Boolean.FALSE);//生成代码无注解
        return generate;
    }

    public static void main(String[] args) throws Exception {
        //数据库名称
        String schemaName = "test";
        //生成数据存储路径  包名
        String packageName = "com.test.entity";
        //数据库需要生成数据的表  正则表达式
        String includes = ".*";
        //数据库中不需要生成数据的表 正则表达式
        String excludes = "";
        genTables(schemaName, packageName, includes, excludes);
    }

}