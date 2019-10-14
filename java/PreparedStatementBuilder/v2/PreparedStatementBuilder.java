package fr.gravendev.multibot.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * PreparedStatementBuilder (v2)
 *
 * @author Antoine James Tournepiche
 * @version 1.0.1
 */
@SuppressWarnings("unused")
public class PreparedStatementBuilder {
    private int parameterIndex = 1;
    private boolean hasPreparedStatement = false;
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
        PreparedStatementBuilder newInstance = new PreparedStatementBuilder(connection);
		preparedStatement = newInstance.connection.prepareStatement(sql);
        newInstance.hasPreparedStatement = true;
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
     *
     * @param str A string value
     * @return this instance
     * @throws SQLException
     * @since 1.0.0
     */
    public PreparedStatementBuilder setString(String str) throws SQLException {
        throwExceptionIfNotAlreadyPrepared();
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
        throwExceptionIfNotAlreadyPrepared();
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
        throwExceptionIfNotAlreadyPrepared();
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
        throwExceptionIfNotAlreadyPrepared();
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
        return preparedStatement.execute();
    }
}
