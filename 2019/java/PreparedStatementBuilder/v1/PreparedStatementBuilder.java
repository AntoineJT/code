/*
 * MIT License
 *
 * Copyright (c) 2019 Antoine James Tournepiche
 * Repository : https://github.com/AntoineJT/code/
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * PreparedStatementBuilder (v1)
 *
 * @author Antoine James Tournepiche
 * @version 1.0.0
 */
@SuppressWarnings("unused")
public class PreparedStatementBuilder {
    private int parameterIndex = 1;
    private boolean hasPreparedStatement = false;
    private boolean hasExecutedBefore = false;
    private final Connection connection;
    private PreparedStatement preparedStatement;

    /**
     *
     * @param connection A database connection instance
     * @since 1.0.0
     */
    public PreparedStatementBuilder(Connection connection){
        this.connection = connection;
    }

    /**
     *
     * @since 1.0.0
     */
    private void incrementParameterIndex(){
        parameterIndex++;
    }

    /**
     *
     * @param sql SQL query
     * @return this instance
     * @throws SQLException
     * @since 1.0.0
     */
    public PreparedStatementBuilder prepareStatement(String sql) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        parameterIndex = 1; // reset it to be able to chain statements
        hasPreparedStatement = true;
        hasExecutedBefore = false;
        return this;
    }

    /**
     * @since 1.0.0
     */
    private void throwExceptionIfNotAlreadyPrepared(){
        if (!hasPreparedStatement){
            throw new IllegalStateException("You must prepare statement before to set arguments value!");
        }
    }

    /**
     * @since 1.0.0
     */
    private void throwExceptionIfAlreadyExecuted(){
        if (hasExecutedBefore){
            throw new IllegalStateException("You cannot set a value to a previously executed query!");
        }
    }

    /**
     * @since 1.0.0
     */
    private void tryToThrowSettersExceptions(){
        throwExceptionIfNotAlreadyPrepared();
        throwExceptionIfAlreadyExecuted();
    }

    /**
     *
     * @param str A string value
     * @return this instance
     * @throws SQLException
     * @since 1.0.0
     */
    public PreparedStatementBuilder setString(String str) throws SQLException {
        tryToThrowSettersExceptions();
        preparedStatement.setString(parameterIndex, str);
        incrementParameterIndex();
        return this;
    }

    /**
     *
     * @param i An integer value
     * @return this instance
     * @throws SQLException
     * @since 1.0.0
     */
    public PreparedStatementBuilder setInt(int i) throws SQLException {
        tryToThrowSettersExceptions();
        preparedStatement.setInt(parameterIndex, i);
        incrementParameterIndex();
        return this;
    }

    /**
     *
     * @param timestamp A timestamp value
     * @return this instance
     * @throws SQLException
     * @since 1.0.0
     */
    public PreparedStatementBuilder setTimestamp(Timestamp timestamp) throws SQLException {
        tryToThrowSettersExceptions();
        preparedStatement.setTimestamp(parameterIndex, timestamp);
        incrementParameterIndex();
        return this;
    }

    /**
     *
     * @param bool A boolean value
     * @return this instance
     * @throws SQLException
     * @since 1.0.0
     */
    public PreparedStatementBuilder setBoolean(boolean bool) throws SQLException {
        tryToThrowSettersExceptions();
        preparedStatement.setBoolean(parameterIndex, bool);
        incrementParameterIndex();
        return this;
    }

    /**
     *
     * @return PreparedStatement#executeUpdate return value
     * @throws SQLException
     * @since 1.0.0
     */
    public int executeUpdate() throws SQLException {
        throwExceptionIfNotAlreadyPrepared();
        hasExecutedBefore = true;
        return preparedStatement.executeUpdate();
    }

    /**
     *
     * @return PreparedStatement#executeQuery return value
     * @throws SQLException
     * @since 1.0.0
     */
    public ResultSet executeQuery() throws SQLException {
        throwExceptionIfNotAlreadyPrepared();
        hasExecutedBefore = true;
        return preparedStatement.executeQuery();
    }

    /**
     *
     * @return PreparedStatement#execute return value
     * @throws SQLException
     * @since 1.0.0
     */
    public boolean execute() throws SQLException {
        throwExceptionIfNotAlreadyPrepared();
        hasExecutedBefore = true;
        return preparedStatement.execute();
    }
}
