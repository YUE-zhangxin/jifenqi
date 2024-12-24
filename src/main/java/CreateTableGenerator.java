import java.io.FileWriter;
import java.io.IOException;

public class CreateTableGenerator {
    public static void main(String[] args) {
        // 循环生成80个建表语句
        for (int i = 1; i <= 80; i++) {
            // 生成表名，例如 test01, test02
            String tableName = String.format("test%02d", i);

            // 生成建表语句
            String createTableSql = String.format("DROP TABLE IF EXISTS %s;\nCREATE TABLE %s (\n    name STRING\n);", tableName,tableName);

            // 定义SQL文件名
            String fileName = "D:/generatorSQL/" + tableName + ".sql";

            // 写入文件
            try (FileWriter fileWriter = new FileWriter(fileName)) {
                fileWriter.write(createTableSql);
                System.out.println("生成 SQL 文件: " + fileName);
            } catch (IOException e) {
                System.err.println("写入文件失败: " + fileName);
                e.printStackTrace();
            }
        }
    }
}
