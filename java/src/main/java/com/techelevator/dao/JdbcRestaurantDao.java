package com.techelevator.dao;

import com.techelevator.model.Restaurant;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcRestaurantDao implements RestaurantDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcRestaurantDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return null;
    }

    @Override
    public List<Restaurant> getRestaurants() {
        return null;
    }

    @Override
    public List<Restaurant> getRestaurants(int zip) {
        String sql = "SELECT * FROM Restaurnts WHERE zip = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, zip);
        List<Restaurant> restaurants = new ArrayList<>();
        while(results.next()) {
            Restaurant restaurant = mapRowToRestauramt(results);
            restaurants.add(restaurant);
        }
        return restaurants;
    }

    @Override
    public List<Restaurant> getRestaurants(String city) {
        return null;
    }

    private Restaurant mapRowToRestauramt(SqlRowSet rs) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(rs.getLong("id"));
        restaurant.setAddress(rs.getString("address"));
        restaurant.setCity(rs.getString("city"));
        //TODO:
        return restaurant;
    }
}