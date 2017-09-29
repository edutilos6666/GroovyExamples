package com.edutilos.step1

import groovy.sql.Sql
import groovy.transform.Canonical


class DatabaseExample {

    //sqlite example
    void example2() {
        Class.forName("org.sqlite.JDBC")
        String url = "jdbc:sqlite:Workers.db"
        String driver = "org.sqlite.JDBC"
        String tablename = "Worker"
        Sql.withInstance(url, driver) { sql ->
            String cmd = ""
            //drop table if exists
            try {
                cmd = """drop table if exists $tablename """
                sql.execute cmd
            } catch(Exception ex) {
                println ex.message
            }

            //create table
            try {
                cmd = """create table if not exists $tablename (
id bigint primary key , 
name varchar(50) not null, 
age int not null, 
wage real not null,
active boolean not null 
)"""
                sql.execute cmd
            } catch(Exception ex) {
                println ex.message
            }


            //insert into table
            List<WorkerSQL> listWorkers = generateData()
            cmd = "insert into $tablename VALUES(?,?,?,?,?)"
            listWorkers.each { w ->
                def params = [w.id, w.name, w.age, w.wage, w.active]
                sql.execute cmd , params
            }

            //select all
            cmd = "select * from $tablename"
            sql.eachRow(cmd) {row ->
                println convertRowToWorker(row)
//                println row
            }

            //update
            cmd = """update $tablename set name = ?, age = ?, wage = ?, active = ? 
where id = ?"""
            try {
                def params = ["new foo", 66, 666.6, false, 1]
                sql.execute cmd , params
            } catch(Exception ex) {
                println ex.message
            }

            println("<<after update>>")
            cmd = "select * from $tablename where id = ?"
            sql.eachRow(cmd, [1]) {row ->
                println convertRowToWorker(row)
            }


            //delete
            cmd = """delete from $tablename where id = ?"""
            try {
                def params = [1]
                sql.execute cmd, params
            } catch(Exception ex) {
                println ex.message
            }

            //all
            cmd = "select * from $tablename"
            println("<<all workers after delete>>")
            sql.eachRow(cmd) {row ->
                println convertRowToWorker(row)
            }

        }
    }


    //mysql example
    void example1() {
        String url = "jdbc:mysql://localhost:3306/test2?useSSL=false"
        String user = "root"
        String password = "root"
        String driver = "com.mysql.jdbc.Driver"
        String tablename = "Worker"
        Sql.withInstance(url, user, password, driver) { sql ->
            String cmd = ""
            //drop table if exists
            try {
                cmd = """drop table if exists $tablename """
                sql.execute cmd
            } catch(Exception ex) {
                println ex.message
            }

            //create table
            try {
                cmd = """create table if not exists $tablename (
id bigint primary key , 
name varchar(50) not null, 
age int not null, 
wage real not null,
active boolean not null 
)"""
                sql.execute cmd
            } catch(Exception ex) {
                println ex.message
            }


            //insert into table
            List<WorkerSQL> listWorkers = generateData()
            cmd = "insert into $tablename VALUES(?,?,?,?,?)"
            listWorkers.each { w ->
                def params = [w.id, w.name, w.age, w.wage, w.active]
                sql.execute cmd , params
            }

            //select all
            cmd = "select * from $tablename"
            sql.eachRow(cmd) {row ->
                println convertRowToWorker(row)
//                println(row )
            }

            //update
            cmd = """update $tablename set name = ?, age = ?, wage = ?, active = ? 
where id = ?"""
            try {
                def params = ["new foo", 66, 666.6, false, 1]
                sql.execute cmd , params
            } catch(Exception ex) {
                println ex.message
            }

            println("<<after update>>")
            cmd = "select * from $tablename where id = ?"
            sql.eachRow(cmd, [1]) {row ->
                println convertRowToWorker(row)
            }


            //delete
            cmd = """delete from $tablename where id = ?"""
            try {
                def params = [1]
                sql.execute cmd, params
            } catch(Exception ex) {
                println ex.message
            }

            //all
            cmd = "select * from $tablename"
            println("<<all workers after delete>>")
            sql.eachRow(cmd) {row ->
                println convertRowToWorker(row)
            }

        }
    }

    private WorkerSQL convertRowToWorker(def row) {
        try {
            new WorkerSQL(
                    row["id"].toLong(),
                    row["name"],
                    row["age"].toInteger(),
                    row["wage"].toDouble(),
                    row["active"].toBoolean()
            )
        } catch(Exception ex) {
            new WorkerSQL(
                    row["id"].toLong(),
                    row["name"],
                    row["age"].toInteger(),
                    row["wage"].toDouble(),
                    row["active"] == 0?false:true
            )
        }

    }
    private List<WorkerSQL> generateData() {
        [
                new WorkerSQL(1, "foo", 10, 100.0, true),
                new WorkerSQL(2, "bar", 20, 200.0, false),
                new WorkerSQL(3, "bim", 30, 300.0 , true),
                new WorkerSQL(4, "pako", 40, 400.0, false)
        ]
    }


    @Canonical
    private class WorkerSQL {
        long id
        String name
        int age
        double wage
        boolean active

        @Override
        String toString() {
            "$id,$name,$age,$wage,$active"
        }
    }
}
