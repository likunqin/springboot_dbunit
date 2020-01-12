package cn.brickie.config;

import org.apache.commons.collections4.CollectionUtils;
import org.dbunit.dataset.*;
import org.springframework.core.io.Resource;
import org.yaml.snakeyaml.Yaml;

import java.util.*;

public class YamlDataSet implements IDataSet {

    private Map<String, YamlDatasetTable> tables = new HashMap<>();

    public YamlDataSet(Resource resource) throws Exception {
        Yaml yaml = new Yaml();
        Map<String, List<Map>> data = yaml.loadAs(resource.getInputStream(), Map.class);
        for (Map.Entry<String, List<Map>> ent : data.entrySet()) {
            String tableName = ent.getKey();
            List<Map> rows = ent.getValue();
            parseDate(rows);
            createTable(tableName, rows);
        }
    }

    @Override
    public String[] getTableNames() throws DataSetException {
        return tables.keySet().toArray(new String[tables.size()]);
    }

    @Override
    public ITableMetaData getTableMetaData(String tableName) throws DataSetException {
        return tables.get(tableName).getTableMetaData();
    }

    @Override
    public ITable getTable(String tableName) throws DataSetException {
        return tables.get(tableName);
    }

    @Override
    public ITable[] getTables() throws DataSetException {
        return tables.values().toArray(new ITable[tables.size()]);
    }

    @Override
    public ITableIterator iterator() throws DataSetException {
        return new DefaultTableIterator(getTables());
    }

    @Override
    public ITableIterator reverseIterator() throws DataSetException {
        return new DefaultTableIterator(getTables(), true);
    }

    @Override
    public boolean isCaseSensitiveTableNames() {
        return false;
    }

    YamlDatasetTable createTable(String name, List<Map> rows) {
        YamlDatasetTable table = buildTable(name, rows);
        tables.put(name, table);
        return table;
    }

    private YamlDatasetTable buildTable(String name, List<Map> rows) {
        if (Objects.isNull(rows)) {
            return new YamlDatasetTable(name, new ArrayList<>());
        }
        List<String> columnNames = rows.size() > 0 ? new ArrayList(rows.get(0).keySet()) : null;
        YamlDatasetTable table = new YamlDatasetTable(name, columnNames);
        for (Map values : rows) {
            table.addRow(values);
        }
        return table;
    }

    private void parseDate(List<Map> rows) {
        if (CollectionUtils.isEmpty(rows)) {
            return;
        }
        for (Map row : rows) {
            Set<Map.Entry> entries = row.entrySet();
            for (Map.Entry field : entries) {
                Object valueObj = field.getValue();
                if (Objects.nonNull(valueObj)) {
                    String value = String.valueOf(valueObj);
                    row.put(field.getKey(), YamlDateParser.parseYamlDate(value));
                }
            }
        }
    }
}
