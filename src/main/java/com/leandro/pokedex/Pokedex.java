package com.leandro.pokedex;

import static org.apache.commons.lang.StringUtils.capitalize;

import java.util.List;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Pokedex {

	private Dataset<Row> dataset;

	public Pokedex() {
		dataset = SparkSession
			.builder()
			.appName("Pokedex")
			.config("spark.master", "local")
			.getOrCreate()
			.read()
			.json("src/main/resources/pokedex.json");
	}

	public Pokemon search(Integer number, String name) {
		List<Row> rows = dataset.select(dataset.col("Number"), dataset.col("Name"))
			.filter(dataset.col("Number").eqNullSafe(number)
					.or(dataset.col("Name").eqNullSafe(capitalize(name.toLowerCase())))).collectAsList();
		
		if (rows.isEmpty())
			return new Pokemon();
			
		Row row = rows.get(0);
		Long resultNumber = row.getAs(0);
		String resultName = row.getAs(1);
		
		return new Pokemon(resultNumber, resultName);
	}

}