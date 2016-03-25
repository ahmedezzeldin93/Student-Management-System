package com.ahmedezzeldin.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("studentsDao")
public class StudentsDao {

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Student> getStudents() {

		return jdbc.query("select * from students", new RowMapper<Student>() {

			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();

				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				student.setDepartment(rs.getString("department"));

				return student;
			}

		});
	}

	public boolean update(Student student) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(
				student);

		return jdbc
				.update("update students set name=:name, department=:department, age=:age where id=:id",
						params) == 1;
	}

	public boolean create(Student student) {

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(
				student);

		return jdbc
				.update("insert into students (name, age, department) values (:name, :age, :department)",
						params) == 1;
	}

	@Transactional
	public int[] create(List<Student> students) {

		SqlParameterSource[] params = SqlParameterSourceUtils
				.createBatch(students.toArray());

		return jdbc
				.batchUpdate(
						"insert into students (id, name, age, department) values (:id, :name, :age, :department)",
						params);
	}

	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);

		return jdbc.update("delete from students where id=:id", params) == 1;
	}

	public Student getStudent(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from students where id=:id", params,
				new RowMapper<Student>() {

					public Student mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Student student = new Student();

						student.setId(rs.getInt("id"));
						student.setName(rs.getString("name"));
						student.setAge(rs.getInt("age"));
						student.setDepartment(rs.getString("department"));

						return student;
					}

				});
	}

}