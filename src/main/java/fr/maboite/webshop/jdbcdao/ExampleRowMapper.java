package fr.maboite.webshop.jdbcdao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.maboite.webshop.model.Example;

/**
 * Fait correspondre un ResultSet jdbc avec un Example, 
 * via la méthode mapRow
 */
public class ExampleRowMapper implements RowMapper<Example> {
	
    @Override
    public Example mapRow(ResultSet rs, int rowNum) throws SQLException {
        Example example = new Example();
        
        example.setId(rs.getLong("ID"));
        example.setNom(rs.getString("NOM"));

        return example;
    }
}