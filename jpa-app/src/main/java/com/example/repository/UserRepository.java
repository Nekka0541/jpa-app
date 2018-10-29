package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

//インターフェースを継承
//UserRepositoryインターフェースがJPARepositoryを継承
//JPARepositoryのジェネリックにはEntityクラス名と、PRIMARY KEYのカラムを受け取るフィールドの型を指定

/**
 * テーブルをEntityにマッピングするリポジトリ
 * 
 * @author sjdu002
 *
 */
public interface UserRepository extends JpaRepository<User, String> {

}
