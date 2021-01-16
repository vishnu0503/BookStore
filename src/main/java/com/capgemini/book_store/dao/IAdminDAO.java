package com.capgemini.book_store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.book_store.bean.Admin;

public interface IAdminDAO extends JpaRepository<Admin, Integer>{

}
