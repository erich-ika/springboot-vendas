package io.github.erichika.domain.repository;

import io.github.erichika.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Clientes {

    private static final String INSERT = "insert into cliente (nome) values (?)";
    private static final String SELECT_ALL = "select * from cliente";
    private static final String SELECT_POR_NOME = SELECT_ALL.concat(" where nome like ?");
    private static final String UPDATE = "update cliente set nome = ? where id = ?";
    private static final String DELETE = "delete from cliente where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cliente salvar(Cliente cliente) {
        jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
        return cliente;
    }

    public Cliente atualizar(Cliente cliente) {
        jdbcTemplate.update(UPDATE, new Object[]{cliente.getNome(), cliente.getId()});
        return cliente;
    }

    public void deletar(Cliente cliente) {
        deletar(cliente.getId());
    }

    public List<Cliente> buscarPorNome(String nome) {
        return jdbcTemplate.query(
                SELECT_POR_NOME,
                new Object[]{"%" + nome + "%"},
                getClientMapper()
        );
    }

    public void deletar(int id) {
        jdbcTemplate.update(DELETE, new Object[]{id});
    }

    public List<Cliente> obterTodos() {
        return jdbcTemplate.query(SELECT_ALL, getClientMapper());
    }

    private static RowMapper<Cliente> getClientMapper() {
        return new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome")
                );
            }
        };
    }
}
