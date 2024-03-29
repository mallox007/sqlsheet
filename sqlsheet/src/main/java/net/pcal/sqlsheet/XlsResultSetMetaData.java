/*
 * Copyright 2012 pcal.net
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.pcal.sqlsheet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;


/**
 * SqlSheet implementation of java.sql.ResultSetMetaData.
 *
 * @author <a href='http://www.pcal.net'>pcal</a>
 * @author <a href='http://code.google.com/p/sqlsheet'>sqlsheet</a>
 */
public class XlsResultSetMetaData implements ResultSetMetaData {

    private String[] columnNames;
    private final DataFormatter formatter;
    private XlsResultSet resultset;

    public XlsResultSetMetaData(Sheet sheet, XlsResultSet resultset, int firstSheetRowOffset) throws SQLException {
        if (sheet == null) throw new IllegalArgumentException();
        this.resultset = resultset;
        Row row = sheet.getRow(firstSheetRowOffset - 1);
        if (row == null) {
            throw new SQLException("No header row in sheet");
        }
        formatter = new DataFormatter();
        columnNames = new String[row.getLastCellNum()];
        for (short c = 0; c < columnNames.length; c++) {
            Cell cell = row.getCell(c);
            columnNames[c] = formatter.formatCellValue(cell);
        }
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnLabel(int jdbcCol) {
        return columnNames[jdbcCol - 1];
    }

    public String getColumnName(int jdbcCol) {
        return columnNames[jdbcCol - 1];
    }

    public String getCatalogName(int arg0) throws SQLException {
        return null;
    }

    public String getColumnClassName(int jdbcColumn) throws SQLException {
        return resultset.getNextRowObject(jdbcColumn).getClass().getName();
    }

    public int getColumnDisplaySize(int arg0) {
        return 0;
    }

    public int getColumnType(int jdbcColumn) throws SQLException {
        if (resultset.getNextRowObject(jdbcColumn).getClass().isAssignableFrom(String.class)) {
            return Types.VARCHAR;
        } else if (resultset.getNextRowObject(jdbcColumn).getClass().isAssignableFrom(Double.class)) {
            return Types.DOUBLE;
        } else if (resultset.getNextRowObject(jdbcColumn).getClass().isAssignableFrom(Date.class)) {
            return Types.DATE;
        }
        return Types.OTHER;
    }

    public String getColumnTypeName(int jdbcColumn) throws SQLException {
        return resultset.getNextRowObject(jdbcColumn).getClass().getName();
    }

    public int getPrecision(int arg0) throws SQLException {
        return 0;
    }

    public int getScale(int arg0) throws SQLException {
        return 0;
    }

    public String getSchemaName(int arg0) throws SQLException {
        return null;
    }

    public String getTableName(int arg0) throws SQLException {
        return null;
    }

    public boolean isAutoIncrement(int arg0) throws SQLException {
        return false;
    }

    public boolean isCaseSensitive(int arg0) throws SQLException {
        return false;
    }

    public boolean isCurrency(int arg0) throws SQLException {
        return false;
    }

    public boolean isDefinitelyWritable(int arg0) throws SQLException {
        return false;
    }

    public int isNullable(int arg0) throws SQLException {
        return 0;
    }

    public boolean isReadOnly(int arg0) throws SQLException {
        return false;
    }

    public boolean isSearchable(int arg0) throws SQLException {
        return false;
    }

    public boolean isSigned(int arg0) throws SQLException {
        return false;
    }

    public boolean isWritable(int arg0) throws SQLException {
        return false;
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

}
